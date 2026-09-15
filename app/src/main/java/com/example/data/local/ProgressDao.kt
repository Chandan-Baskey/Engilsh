package com.example.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {
    @Query("SELECT * FROM module_progress")
    fun getAllModuleProgress(): Flow<List<ModuleProgressEntity>>

    @Query("SELECT * FROM module_progress WHERE moduleId = :id")
    suspend fun getModuleProgress(id: Int): ModuleProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveModuleProgress(progress: ModuleProgressEntity)

    @Query("SELECT * FROM practice_history ORDER BY timestamp DESC")
    fun getPracticeHistory(): Flow<List<PracticeHistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPracticeRecord(record: PracticeHistoryEntity)

    @Query("SELECT * FROM saved_phrases ORDER BY savedAt DESC")
    fun getSavedPhrases(): Flow<List<SavedPhraseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePhrase(phrase: SavedPhraseEntity)

    @Query("DELETE FROM saved_phrases WHERE phraseId = :phraseId")
    suspend fun removePhrase(phraseId: String)

    @Query("SELECT EXISTS(SELECT 1 FROM saved_phrases WHERE phraseId = :phraseId)")
    fun isPhraseSaved(phraseId: String): Flow<Boolean>

    @Query("SELECT * FROM chat_messages WHERE scenarioId = :scenarioId ORDER BY timestamp ASC")
    fun getChatMessages(scenarioId: String): Flow<List<ChatMessageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChatMessage(message: ChatMessageEntity)

    @Query("DELETE FROM chat_messages WHERE scenarioId = :scenarioId")
    suspend fun clearChatHistory(scenarioId: String)

    @Query("DELETE FROM module_progress")
    suspend fun resetAllModuleProgress()
}
