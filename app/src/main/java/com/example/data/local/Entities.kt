package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "module_progress")
data class ModuleProgressEntity(
    @PrimaryKey val moduleId: Int,
    val isCompleted: Boolean = false,
    val score: Int = 0,
    val totalQuestions: Int = 0,
    val lastAccessedTime: Long = System.currentTimeMillis()
)

@Entity(tableName = "practice_history")
data class PracticeHistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val modeType: String,
    val questionsAttempted: Int,
    val questionsCorrect: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "saved_phrases")
data class SavedPhraseEntity(
    @PrimaryKey val phraseId: String,
    val englishText: String,
    val hinglishMeaning: String,
    val category: String,
    val note: String = "",
    val savedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "chat_messages")
data class ChatMessageEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val scenarioId: String,
    val sender: String, // "ai" or "user"
    val messageText: String,
    val hasMistake: Boolean = false,
    val correctedEnglish: String = "",
    val explanationHinglish: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
