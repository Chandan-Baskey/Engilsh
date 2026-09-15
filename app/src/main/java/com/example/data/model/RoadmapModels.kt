package com.example.data.model

data class RoadmapModule(
    val id: Int,
    val title: String,
    val subtitleHinglish: String,
    val iconEmoji: String,
    val category: String, // e.g., "Basics", "Grammar Engine", "Sentence Mastery", "Real Speaking"
    val estimatedMinutes: Int,
    val overviewHinglish: String,
    val coreConceptRule: String,
    val sections: List<LessonSection>,
    val commonMistakes: List<CommonMistake>,
    val examples: List<ExampleSentence>,
    val quizQuestions: List<QuizQuestion>
)

data class LessonSection(
    val title: String,
    val explanationHinglish: String,
    val formulaOrStructure: String = "",
    val bulletPointsHinglish: List<String> = emptyList(),
    val keyExamples: List<ExampleSentence> = emptyList()
)

data class CommonMistake(
    val incorrectEnglish: String,
    val correctEnglish: String,
    val reasonHinglish: String
)

data class ExampleSentence(
    val english: String,
    val hinglish: String,
    val tipHinglish: String = ""
)

data class QuizQuestion(
    val id: Int,
    val questionHinglish: String,
    val promptEnglish: String = "",
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanationHinglish: String
)
