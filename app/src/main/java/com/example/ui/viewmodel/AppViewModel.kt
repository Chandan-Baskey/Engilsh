package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.ChatMessageEntity
import com.example.data.local.ModuleProgressEntity
import com.example.data.local.PracticeHistoryEntity
import com.example.data.local.SavedPhraseEntity
import com.example.data.model.ConversationScenario
import com.example.data.repository.LearningRepository
import com.example.data.roadmap.ScenarioDataProvider
import com.example.data.roadmap.VocabItem
import com.example.util.TextToSpeechHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val database = AppDatabase.getDatabase(application)
    private val repository = LearningRepository(database.progressDao())
    val ttsHelper = TextToSpeechHelper(application)

    val moduleProgress: StateFlow<List<ModuleProgressEntity>> =
        repository.allModuleProgress.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    val practiceHistory: StateFlow<List<PracticeHistoryEntity>> =
        repository.practiceHistory.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    val savedPhrases: StateFlow<List<SavedPhraseEntity>> =
        repository.savedPhrases.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    // AI Chat State
    private val _selectedScenario = MutableStateFlow<ConversationScenario>(ScenarioDataProvider.scenarios.first())
    val selectedScenario: StateFlow<ConversationScenario> = _selectedScenario.asStateFlow()

    private val _chatMessages = MutableStateFlow<List<ChatMessageEntity>>(emptyList())
    val chatMessages: StateFlow<List<ChatMessageEntity>> = _chatMessages.asStateFlow()

    private val _isAiLoading = MutableStateFlow(false)
    val isAiLoading: StateFlow<Boolean> = _isAiLoading.asStateFlow()

    init {
        loadScenarioChat(_selectedScenario.value)
    }

    fun selectScenario(scenario: ConversationScenario) {
        _selectedScenario.value = scenario
        loadScenarioChat(scenario)
    }

    private fun loadScenarioChat(scenario: ConversationScenario) {
        viewModelScope.launch {
            repository.getChatMessages(scenario.id).collect { msgs ->
                if (msgs.isEmpty()) {
                    // Insert initial welcome AI message
                    val initial = ChatMessageEntity(
                        scenarioId = scenario.id,
                        sender = "ai",
                        messageText = scenario.initialAiMessage,
                        timestamp = System.currentTimeMillis()
                    )
                    repository.insertChatMessage(initial)
                } else {
                    _chatMessages.value = msgs
                }
            }
        }
    }

    fun sendUserChatMessage(userText: String) {
        val scenario = _selectedScenario.value
        val userEntity = ChatMessageEntity(
            scenarioId = scenario.id,
            sender = "user",
            messageText = userText,
            timestamp = System.currentTimeMillis()
        )

        viewModelScope.launch {
            repository.insertChatMessage(userEntity)
            _isAiLoading.value = true

            val currentMsgs = _chatMessages.value
            val history = currentMsgs.map { it.sender to it.messageText }

            val feedback = repository.evaluateAndRespond(
                scenarioRole = scenario.systemPromptRole,
                history = history,
                userMessage = userText
            )

            // Update user's message with evaluation
            val updatedUserMsg = userEntity.copy(
                hasMistake = feedback.hasMistake,
                correctedEnglish = feedback.correctedEnglish,
                explanationHinglish = feedback.explanationHinglish
            )
            repository.insertChatMessage(updatedUserMsg)

            // Combine AI response & single next question
            val fullAiReply = "${feedback.conversationalReplyEnglish} ${feedback.nextQuestionEnglish}".trim()
            val aiMsgEntity = ChatMessageEntity(
                scenarioId = scenario.id,
                sender = "ai",
                messageText = fullAiReply,
                timestamp = System.currentTimeMillis() + 50
            )
            repository.insertChatMessage(aiMsgEntity)
            _isAiLoading.value = false
        }
    }

    fun clearCurrentChatHistory() {
        val scenario = _selectedScenario.value
        viewModelScope.launch {
            repository.clearChatHistory(scenario.id)
            val initial = ChatMessageEntity(
                scenarioId = scenario.id,
                sender = "ai",
                messageText = scenario.initialAiMessage,
                timestamp = System.currentTimeMillis()
            )
            repository.insertChatMessage(initial)
        }
    }

    fun markModuleCompleted(moduleId: Int, score: Int, total: Int) {
        viewModelScope.launch {
            repository.markModuleCompleted(moduleId, score, total)
        }
    }

    fun savePracticeRecord(modeType: String, total: Int, correct: Int) {
        viewModelScope.launch {
            repository.savePracticeSession(modeType, total, correct)
        }
    }

    fun toggleSaveVocabItem(item: VocabItem) {
        viewModelScope.launch {
            val isAlreadySaved = savedPhrases.value.any { it.phraseId == item.id }
            if (isAlreadySaved) {
                repository.removeSavedPhrase(item.id)
            } else {
                repository.toggleSavePhrase(
                    id = item.id,
                    english = item.wordOrPhrase,
                    hinglish = item.hinglishMeaning,
                    category = item.category
                )
            }
        }
    }

    fun resetAllProgress() {
        viewModelScope.launch {
            repository.resetAllProgress()
        }
    }

    fun playAudio(text: String, isSlow: Boolean = false) {
        ttsHelper.speak(text, isSlow)
    }

    override fun onCleared() {
        super.onCleared()
        ttsHelper.shutdown()
    }
}
