package com.example.ui.navigation

sealed class Screen(val route: String, val titleHinglish: String, val iconEmoji: String) {
    object Home : Screen("home", "Home", "🏠")
    object Roadmap : Screen("roadmap", "Roadmap", "🗺️")
    object PracticeHub : Screen("practice_hub", "Practice", "🎯")
    object AiPartner : Screen("ai_partner", "AI Partner", "🤖")
    object Vocabulary : Screen("vocabulary", "Vocab & Phrases", "📚")
    object Profile : Screen("profile", "My Profile", "👤")

    // Sub-screens
    data class LessonDetail(val moduleId: Int) : Screen("lesson_detail/$moduleId", "Lesson", "📖")
    data class PracticeModeScreen(val modeId: String) : Screen("practice_mode/$modeId", "Practice", "⚡")
}
