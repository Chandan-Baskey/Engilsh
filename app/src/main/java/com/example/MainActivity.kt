package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.navigation.Screen
import com.example.ui.screens.AiConversationScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.PracticeExerciseScreen
import com.example.ui.screens.PracticeHubScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.RoadmapScreen
import com.example.ui.screens.VocabularyScreen
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                BolEnglishApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun BolEnglishApp(viewModel: AppViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val moduleProgressList by viewModel.moduleProgress.collectAsState()
    val practiceHistory by viewModel.practiceHistory.collectAsState()
    val savedPhrases by viewModel.savedPhrases.collectAsState()
    val selectedScenario by viewModel.selectedScenario.collectAsState()
    val chatMessages by viewModel.chatMessages.collectAsState()
    val isAiLoading by viewModel.isAiLoading.collectAsState()

    val bottomNavItems = listOf(
        Screen.Home,
        Screen.Roadmap,
        Screen.PracticeHub,
        Screen.AiPartner,
        Screen.Vocabulary,
        Screen.Profile
    )

    val showBottomBar = currentRoute in bottomNavItems.map { it.route }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp,
                    modifier = Modifier.testTag("bottom_navigation_bar")
                ) {
                    bottomNavItems.forEach { screen ->
                        val isSelected = currentRoute == screen.route
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Text(
                                    text = screen.iconEmoji,
                                    fontSize = 20.sp
                                )
                            },
                            label = {
                                Text(
                                    text = screen.titleHinglish,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontSize = 11.sp
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = PrimaryIndigo,
                                indicatorColor = PrimaryIndigo.copy(alpha = 0.15f)
                            ),
                            modifier = Modifier.testTag("bottom_nav_${screen.route}")
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    completedModules = moduleProgressList,
                    onNavigateToRoadmap = { navController.navigate(Screen.Roadmap.route) },
                    onNavigateToLesson = { moduleId -> navController.navigate("lesson_detail/$moduleId") },
                    onNavigateToPracticeMode = { modeId -> navController.navigate("practice_mode/$modeId") },
                    onNavigateToAiPartner = { navController.navigate(Screen.AiPartner.route) },
                    onPlayAudio = { text, isSlow -> viewModel.playAudio(text, isSlow) }
                )
            }

            composable(Screen.Roadmap.route) {
                RoadmapScreen(
                    progressList = moduleProgressList,
                    onSelectModule = { moduleId -> navController.navigate("lesson_detail/$moduleId") }
                )
            }

            composable(Screen.PracticeHub.route) {
                PracticeHubScreen(
                    onSelectPracticeMode = { modeId -> navController.navigate("practice_mode/$modeId") },
                    onNavigateToAiPartner = { navController.navigate(Screen.AiPartner.route) }
                )
            }

            composable(Screen.AiPartner.route) {
                AiConversationScreen(
                    messages = chatMessages,
                    isLoading = isAiLoading,
                    selectedScenario = selectedScenario,
                    onSelectScenario = { scenario -> viewModel.selectScenario(scenario) },
                    onSendMessage = { text -> viewModel.sendUserChatMessage(text) },
                    onClearHistory = { viewModel.clearCurrentChatHistory() },
                    onPlayAudio = { text, isSlow -> viewModel.playAudio(text, isSlow) }
                )
            }

            composable(Screen.Vocabulary.route) {
                VocabularyScreen(
                    savedPhrases = savedPhrases,
                    onToggleSave = { item -> viewModel.toggleSaveVocabItem(item) },
                    onPlayAudio = { text, isSlow -> viewModel.playAudio(text, isSlow) }
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen(
                    moduleProgressList = moduleProgressList,
                    practiceHistory = practiceHistory,
                    savedPhrases = savedPhrases,
                    onResetProgress = { viewModel.resetAllProgress() }
                )
            }

            composable(
                route = "lesson_detail/{moduleId}",
                arguments = listOf(navArgument("moduleId") { type = NavType.IntType })
            ) { backStackEntry ->
                val moduleId = backStackEntry.arguments?.getInt("moduleId") ?: 1
                LessonDetailScreen(
                    moduleId = moduleId,
                    onBack = { navController.popBackStack() },
                    onPlayAudio = { text, isSlow -> viewModel.playAudio(text, isSlow) },
                    onSaveCompleted = { id, score, total ->
                        viewModel.markModuleCompleted(id, score, total)
                    }
                )
            }

            composable(
                route = "practice_mode/{modeId}",
                arguments = listOf(navArgument("modeId") { type = NavType.StringType })
            ) { backStackEntry ->
                val modeId = backStackEntry.arguments?.getString("modeId") ?: "translation"
                PracticeExerciseScreen(
                    modeId = modeId,
                    onBack = { navController.popBackStack() },
                    onPlayAudio = { text, isSlow -> viewModel.playAudio(text, isSlow) },
                    onSaveSession = { type, total, correct ->
                        viewModel.savePracticeRecord(type, total, correct)
                    }
                )
            }
        }
    }
}
