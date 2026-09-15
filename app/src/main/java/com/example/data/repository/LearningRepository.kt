package com.example.data.repository

import com.example.data.api.GeminiChatClient
import com.example.data.local.ChatMessageEntity
import com.example.data.local.ModuleProgressEntity
import com.example.data.local.PracticeHistoryEntity
import com.example.data.local.ProgressDao
import com.example.data.local.SavedPhraseEntity
import com.example.data.model.AiFeedback
import kotlinx.coroutines.flow.Flow

class LearningRepository(
    private val progressDao: ProgressDao,
    private val geminiClient: GeminiChatClient = GeminiChatClient()
) {

    val allModuleProgress: Flow<List<ModuleProgressEntity>> = progressDao.getAllModuleProgress()
    val practiceHistory: Flow<List<PracticeHistoryEntity>> = progressDao.getPracticeHistory()
    val savedPhrases: Flow<List<SavedPhraseEntity>> = progressDao.getSavedPhrases()

    suspend fun markModuleCompleted(moduleId: Int, score: Int, total: Int) {
        progressDao.saveModuleProgress(
            ModuleProgressEntity(
                moduleId = moduleId,
                isCompleted = true,
                score = score,
                totalQuestions = total,
                lastAccessedTime = System.currentTimeMillis()
            )
        )
    }

    suspend fun savePracticeSession(modeType: String, total: Int, correct: Int) {
        progressDao.insertPracticeRecord(
            PracticeHistoryEntity(
                modeType = modeType,
                questionsAttempted = total,
                questionsCorrect = correct,
                timestamp = System.currentTimeMillis()
            )
        )
    }

    suspend fun toggleSavePhrase(id: String, english: String, hinglish: String, category: String) {
        val entity = SavedPhraseEntity(
            phraseId = id,
            englishText = english,
            hinglishMeaning = hinglish,
            category = category,
            savedAt = System.currentTimeMillis()
        )
        progressDao.savePhrase(entity)
    }

    suspend fun removeSavedPhrase(id: String) {
        progressDao.removePhrase(id)
    }

    fun isPhraseSaved(id: String): Flow<Boolean> = progressDao.isPhraseSaved(id)

    fun getChatMessages(scenarioId: String): Flow<List<ChatMessageEntity>> =
        progressDao.getChatMessages(scenarioId)

    suspend fun insertChatMessage(message: ChatMessageEntity) {
        progressDao.insertChatMessage(message)
    }

    suspend fun clearChatHistory(scenarioId: String) {
        progressDao.clearChatHistory(scenarioId)
    }

    suspend fun resetAllProgress() {
        progressDao.resetAllModuleProgress()
    }

    suspend fun evaluateAndRespond(
        scenarioRole: String,
        history: List<Pair<String, String>>,
        userMessage: String
    ): AiFeedback {
        return geminiClient.evaluateAndRespond(scenarioRole, history, userMessage)
    }
}
