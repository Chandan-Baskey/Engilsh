package com.example.data.model

data class ConversationScenario(
    val id: String,
    val title: String,
    val titleHinglish: String,
    val iconEmoji: String,
    val level: String,
    val contextHinglish: String,
    val initialAiMessage: String,
    val systemPromptRole: String,
    val suggestedStarterReplies: List<String>
)

data class AiFeedback(
    val hasMistake: Boolean,
    val correctedEnglish: String,
    val explanationHinglish: String,
    val nextQuestionEnglish: String,
    val conversationalReplyEnglish: String
)
