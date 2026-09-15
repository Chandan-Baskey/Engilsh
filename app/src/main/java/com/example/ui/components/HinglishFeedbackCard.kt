package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.ErrorRedLight
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SuccessGreenLight
import com.example.ui.theme.TertiaryAmber
import com.example.ui.theme.TertiaryAmberLight

@Composable
fun HinglishFeedbackCard(
    isCorrect: Boolean,
    titleHinglish: String,
    explanationHinglish: String,
    correctAnswerEnglish: String? = null,
    onPlayAudio: ((String, Boolean) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val bgColor = if (isCorrect) SuccessGreenLight else ErrorRedLight
    val borderColor = if (isCorrect) SuccessGreen else ErrorRed
    val icon = if (isCorrect) Icons.Default.CheckCircle else Icons.Default.Warning
    val iconTint = if (isCorrect) SuccessGreen else ErrorRed

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(bgColor)
            .border(1.5.dp, borderColor, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .testTag("hinglish_feedback_card")
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = titleHinglish,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = iconTint
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Hinglish Explanation
        Row(verticalAlignment = Alignment.Top) {
            Icon(
                imageVector = Icons.Default.Lightbulb,
                contentDescription = null,
                tint = TertiaryAmber,
                modifier = Modifier.size(18.dp).padding(top = 2.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = explanationHinglish,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 20.sp
            )
        }

        // Show correct English answer if available
        if (!correctAnswerEnglish.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .border(1.dp, borderColor.copy(alpha = 0.3f), RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = "Sahi English Sentence:",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = correctAnswerEnglish,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )
                    if (onPlayAudio != null) {
                        AudioPlayButton(
                            textToSpeak = correctAnswerEnglish,
                            isCurrentlyPlaying = false,
                            onPlay = onPlayAudio
                        )
                    }
                }
            }
        }
    }
}
