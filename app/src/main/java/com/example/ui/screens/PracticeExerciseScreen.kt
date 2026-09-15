package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.roadmap.PracticeDataProvider
import com.example.ui.components.AudioPlayButton
import com.example.ui.components.HinglishFeedbackCard
import com.example.ui.components.WordChip
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.PrimaryIndigoLight
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SuccessGreenLight
import com.example.ui.theme.TertiaryAmber
import com.example.ui.theme.TertiaryAmberLight

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun PracticeExerciseScreen(
    modeId: String,
    onBack: () -> Unit,
    onPlayAudio: (String, Boolean) -> Unit,
    onSaveSession: (modeType: String, total: Int, correct: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var userInputText by remember { mutableStateOf("") }
    var showHint by remember { mutableStateOf(false) }
    var isSubmitted by remember { mutableStateOf(false) }
    var isAnswerCorrect by remember { mutableStateOf(false) }
    var scoreCount by remember { mutableIntStateOf(0) }

    // State for Sentence Building jumbled chips
    val selectedWords = remember { mutableStateListOf<String>() }

    // Mode title
    val modeTitle = when (modeId) {
        "translation" -> "Hinglish to English Translation"
        "quick_qa" -> "Quick Question & Answer"
        "sentence_building" -> "Sentence Building"
        "positive_to_negative" -> "Positive to Negative"
        "make_question" -> "Make a Question"
        else -> "Practice Exercise"
    }

    val totalExercises = when (modeId) {
        "translation" -> PracticeDataProvider.translationExercises.size
        "quick_qa" -> PracticeDataProvider.quickQaExercises.size
        "sentence_building" -> PracticeDataProvider.sentenceBuildExercises.size
        "positive_to_negative" -> PracticeDataProvider.positiveToNegativeExercises.size
        "make_question" -> PracticeDataProvider.makeQuestionExercises.size
        else -> 0
    }

    val isFinished = currentIndex >= totalExercises

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = modeTitle,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("practice_back_button")
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        modifier = modifier
    ) { innerPadding ->
        if (isFinished) {
            // Finished Summary Screen
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(24.dp)
                    ) {
                        Text(text = "🎉", fontSize = 54.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Practice Complete!",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Aapne $totalExercises mein se $scoreCount exercises sahi kiye!",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = {
                                onSaveSession(modeId, totalExercises, scoreCount)
                                onBack()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("practice_finish_done_button")
                        ) {
                            Text("Done & Save Progress", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .testTag("practice_exercise_screen")
            ) {
                // Progress counter
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Exercise ${currentIndex + 1} of $totalExercises",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryIndigo
                        )
                        Text(
                            text = "Score: $scoreCount / ${currentIndex}",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = SuccessGreen
                        )
                    }
                }

                // MODE SPECIFIC PROMPT CARDS
                when (modeId) {
                    "translation" -> {
                        val item = PracticeDataProvider.translationExercises[currentIndex]
                        item {
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(18.dp)) {
                                    Text(
                                        text = "Hinglish Vakya ko English mein translate kijiye:",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.Gray,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = item.hinglishPrompt,
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )

                                    if (item.keyVocabulary.isNotEmpty()) {
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Text(
                                            text = "Vocabulary Help:",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Gray
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        FlowRow(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                                            verticalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            item.keyVocabulary.forEach { (eng, hin) ->
                                                Surface(
                                                    shape = RoundedCornerShape(8.dp),
                                                    color = PrimaryIndigoLight
                                                ) {
                                                    Text(
                                                        text = "$eng: $hin",
                                                        style = MaterialTheme.typography.bodySmall,
                                                        color = PrimaryIndigo,
                                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    "quick_qa" -> {
                        val item = PracticeDataProvider.quickQaExercises[currentIndex]
                        item {
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                elevation = CardDefaults.cardElevation(2.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(18.dp)) {
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = TertiaryAmberLight
                                    ) {
                                        Text(
                                            text = "Situation: ${item.situationHinglish}",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.tertiary,
                                            fontWeight = FontWeight.Medium,
                                            modifier = Modifier.padding(8.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(12.dp))

                                    Text(
                                        text = "Interviewer / AI Question:",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.Gray
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = item.aiQuestionEnglish,
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = PrimaryIndigo,
                                            modifier = Modifier.weight(1f)
                                        )
                                        AudioPlayButton(
                                            textToSpeak = item.aiQuestionEnglish,
                                            isCurrentlyPlaying = false,
                                            onPlay = onPlayAudio
                                        )
                                    }
                                }
                            }
                        }
                    }

                    "sentence_building" -> {
                        val item = PracticeDataProvider.sentenceBuildExercises[currentIndex]
                        item {
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                elevation = CardDefaults.cardElevation(2.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(18.dp)) {
                                    Text(
                                        text = "Sentence ka sahi arth (Meaning):",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.Gray
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = item.hinglishMeaning,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    Text(
                                        text = "Aapka Sentence:",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = PrimaryIndigo,
                                        fontWeight = FontWeight.Bold
                                    )

                                    // Display user built sentence so far
                                    Surface(
                                        shape = RoundedCornerShape(12.dp),
                                        color = PrimaryIndigoLight.copy(alpha = 0.5f),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp)
                                    ) {
                                        Text(
                                            text = if (selectedWords.isEmpty()) "Shabdon ko sahi kram mein tap karein..." else selectedWords.joinToString(" "),
                                            style = MaterialTheme.typography.bodyLarge,
                                            fontWeight = if (selectedWords.isEmpty()) FontWeight.Normal else FontWeight.Bold,
                                            color = if (selectedWords.isEmpty()) Color.Gray else PrimaryIndigo,
                                            modifier = Modifier.padding(14.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    // Jumbled Word Chips
                                    Text(
                                        text = "Tap to add / remove words:",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.Gray
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))

                                    FlowRow(
                                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        verticalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        item.jumbledWords.forEach { word ->
                                            val isChosen = selectedWords.contains(word)
                                            WordChip(
                                                word = word,
                                                isSelected = isChosen,
                                                onClick = {
                                                    if (!isSubmitted) {
                                                        if (isChosen) {
                                                            selectedWords.remove(word)
                                                        } else {
                                                            selectedWords.add(word)
                                                        }
                                                    }
                                                }
                                            )
                                        }
                                    }

                                    if (selectedWords.isNotEmpty() && !isSubmitted) {
                                        Spacer(modifier = Modifier.height(10.dp))
                                        OutlinedButton(
                                            onClick = { selectedWords.clear() },
                                            modifier = Modifier.align(Alignment.End)
                                        ) {
                                            Icon(imageVector = Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text("Reset Words")
                                        }
                                    }
                                }
                            }
                        }
                    }

                    "positive_to_negative" -> {
                        val item = PracticeDataProvider.positiveToNegativeExercises[currentIndex]
                        item {
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                elevation = CardDefaults.cardElevation(2.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(18.dp)) {
                                    Text(
                                        text = "Positive Sentence ko Negative banayein:",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.Gray
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = item.positiveSentenceEnglish,
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = PrimaryIndigo,
                                            modifier = Modifier.weight(1f)
                                        )
                                        AudioPlayButton(
                                            textToSpeak = item.positiveSentenceEnglish,
                                            isCurrentlyPlaying = false,
                                            onPlay = onPlayAudio
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Arth badlav: ${item.hinglishMeaning}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }

                    "make_question" -> {
                        val item = PracticeDataProvider.makeQuestionExercises[currentIndex]
                        item {
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                elevation = CardDefaults.cardElevation(2.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.padding(18.dp)) {
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = TertiaryAmberLight
                                    ) {
                                        Text(
                                            text = "Target Question Type: ${item.targetType}",
                                            style = MaterialTheme.typography.labelMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.tertiary,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    Text(
                                        text = "Statement: \"${item.statementEnglish}\"",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.height(6.dp))

                                    Text(
                                        text = item.promptHinglish,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }

                // User Input Field (For modes other than sentence_building)
                if (modeId != "sentence_building") {
                    item {
                        Column {
                            OutlinedTextField(
                                value = userInputText,
                                onValueChange = { if (!isSubmitted) userInputText = it },
                                label = { Text("Apna English answer type kijiye...") },
                                placeholder = { Text("e.g. Type your sentence here...") },
                                enabled = !isSubmitted,
                                singleLine = false,
                                maxLines = 3,
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                                keyboardActions = KeyboardActions(onDone = { }),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("practice_input_field")
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Hint toggle
                            val hintText = when (modeId) {
                                "translation" -> PracticeDataProvider.translationExercises[currentIndex].hintHinglish
                                "quick_qa" -> PracticeDataProvider.quickQaExercises[currentIndex].hintHinglish
                                "positive_to_negative" -> PracticeDataProvider.positiveToNegativeExercises[currentIndex].grammarRuleHinglish
                                "make_question" -> PracticeDataProvider.makeQuestionExercises[currentIndex].grammarRuleHinglish
                                else -> ""
                            }

                            if (hintText.isNotBlank()) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clickable { showHint = !showHint }
                                        .padding(vertical = 4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Lightbulb,
                                        contentDescription = "Hint",
                                        tint = TertiaryAmber,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (showHint) "Hint: $hintText" else "Madad chahiye? Hinglish Hint dekhein",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = if (showHint) TertiaryAmber else PrimaryIndigo,
                                        fontWeight = if (showHint) FontWeight.Bold else FontWeight.Normal
                                    )
                                }
                            }
                        }
                    }
                }

                // Action Button (Check Answer / Next)
                item {
                    if (!isSubmitted) {
                        Button(
                            onClick = {
                                val cleanInput = if (modeId == "sentence_building") {
                                    selectedWords.joinToString(" ").trim().lowercase().removeSuffix(".")
                                } else {
                                    userInputText.trim().lowercase().removeSuffix(".").removeSuffix("?")
                                }

                                val isCorrect = when (modeId) {
                                    "translation" -> {
                                        val ex = PracticeDataProvider.translationExercises[currentIndex]
                                        ex.acceptableEnglishAnswers.any {
                                            it.trim().lowercase().removeSuffix(".") == cleanInput
                                        } || cleanInput.contains("will not be able") || cleanInput.contains("won't be able")
                                    }
                                    "quick_qa" -> {
                                        val ex = PracticeDataProvider.quickQaExercises[currentIndex]
                                        ex.acceptableEnglishReplies.any {
                                            cleanInput.contains(it.trim().lowercase().removeSuffix("."))
                                        } || cleanInput.length > 5
                                    }
                                    "sentence_building" -> {
                                        val ex = PracticeDataProvider.sentenceBuildExercises[currentIndex]
                                        ex.correctSentenceEnglish.trim().lowercase().removeSuffix(".") == cleanInput
                                    }
                                    "positive_to_negative" -> {
                                        val ex = PracticeDataProvider.positiveToNegativeExercises[currentIndex]
                                        ex.alternateNegatives.any {
                                            it.trim().lowercase().removeSuffix(".") == cleanInput
                                        } || ex.correctNegativeSentence.trim().lowercase().removeSuffix(".") == cleanInput
                                    }
                                    "make_question" -> {
                                        val ex = PracticeDataProvider.makeQuestionExercises[currentIndex]
                                        ex.acceptableQuestions.any {
                                            it.trim().lowercase().removeSuffix("?").removeSuffix(".") == cleanInput
                                        }
                                    }
                                    else -> false
                                }

                                isAnswerCorrect = isCorrect
                                if (isCorrect) scoreCount++
                                isSubmitted = true
                            },
                            enabled = if (modeId == "sentence_building") selectedWords.isNotEmpty() else userInputText.isNotBlank(),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("check_answer_button")
                        ) {
                            Icon(imageVector = Icons.Default.Check, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Check Answer", fontWeight = FontWeight.Bold)
                        }
                    } else {
                        // FEEDBACK CARD
                        val (explanation, correctAns) = when (modeId) {
                            "translation" -> {
                                val ex = PracticeDataProvider.translationExercises[currentIndex]
                                ex.explanationHinglish to ex.acceptableEnglishAnswers.first()
                            }
                            "quick_qa" -> {
                                val ex = PracticeDataProvider.quickQaExercises[currentIndex]
                                ex.explanationHinglish to ex.sampleGoodAnswers.first()
                            }
                            "sentence_building" -> {
                                val ex = PracticeDataProvider.sentenceBuildExercises[currentIndex]
                                ex.explanationHinglish to ex.correctSentenceEnglish
                            }
                            "positive_to_negative" -> {
                                val ex = PracticeDataProvider.positiveToNegativeExercises[currentIndex]
                                ex.grammarRuleHinglish to ex.correctNegativeSentence
                            }
                            "make_question" -> {
                                val ex = PracticeDataProvider.makeQuestionExercises[currentIndex]
                                ex.grammarRuleHinglish to ex.correctQuestionEnglish
                            }
                            else -> "" to ""
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                            HinglishFeedbackCard(
                                isCorrect = isAnswerCorrect,
                                titleHinglish = if (isAnswerCorrect) "Bohot Badhiya! Sahi Jawab 🎉" else "Thoda sa dhyan dein 💡",
                                explanationHinglish = explanation,
                                correctAnswerEnglish = correctAns,
                                onPlayAudio = onPlayAudio
                            )

                            Button(
                                onClick = {
                                    isSubmitted = false
                                    userInputText = ""
                                    selectedWords.clear()
                                    showHint = false
                                    currentIndex++
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryIndigo),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("next_exercise_button")
                            ) {
                                Text(
                                    text = if (currentIndex + 1 < totalExercises) "Agla Sawal (Next)" else "Finish Practice",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}
