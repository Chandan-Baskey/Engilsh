package com.example.data.model

enum class PracticeMode(val id: String, val title: String, val hinglishDesc: String, val iconEmoji: String) {
    TRANSLATION(
        "translation",
        "Hinglish to English",
        "Hinglish sentence ko sahi English mein translate karo",
        "🔄"
    ),
    QUICK_QA(
        "quick_qa",
        "Quick Q & A",
        "Daily communication sawalon ke English mein jawab do",
        "💬"
    ),
    SENTENCE_BUILDING(
        "sentence_building",
        "Sentence Building",
        "Bikhre hue words ko sahi kram (S-V-O) mein jod kar sentence banao",
        "🧩"
    ),
    POSITIVE_TO_NEGATIVE(
        "pos_to_neg",
        "Positive to Negative",
        "Haan-waale sentence ko Naa-waale (negative) sentence mein badlo",
        "⚡"
    ),
    MAKE_A_QUESTION(
        "make_question",
        "Make a Question",
        "Normal sentence ya situation se sahi English sawal banao",
        "❓"
    ),
    AI_PARTNER(
        "ai_partner",
        "AI Conversation Partner",
        "AI se 1-by-1 English baatcheet karo, Hinglish feedback ke saath",
        "🤖"
    )
}

data class TranslationExercise(
    val id: Int,
    val hinglishPrompt: String,
    val acceptableEnglishAnswers: List<String>,
    val hintHinglish: String,
    val explanationHinglish: String,
    val keyVocabulary: List<Pair<String, String>> = emptyList() // English -> Hinglish
)

data class QuickQaExercise(
    val id: Int,
    val situationHinglish: String,
    val aiQuestionEnglish: String,
    val acceptableEnglishReplies: List<String>,
    val sampleGoodAnswers: List<String>,
    val hintHinglish: String,
    val explanationHinglish: String
)

data class SentenceBuildExercise(
    val id: Int,
    val hinglishMeaning: String,
    val correctSentenceEnglish: String,
    val jumbledWords: List<String>,
    val explanationHinglish: String
)

data class PositiveToNegativeExercise(
    val id: Int,
    val positiveSentenceEnglish: String,
    val hinglishMeaning: String,
    val correctNegativeSentence: String,
    val alternateNegatives: List<String> = emptyList(),
    val grammarRuleHinglish: String
)

data class MakeQuestionExercise(
    val id: Int,
    val statementEnglish: String,
    val targetType: String, // "Yes/No Question" or "Wh- Question"
    val promptHinglish: String,
    val correctQuestionEnglish: String,
    val acceptableQuestions: List<String> = emptyList(),
    val grammarRuleHinglish: String
)
