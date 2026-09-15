package com.example.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.PrimaryIndigo
import com.example.ui.theme.PrimaryIndigoLight

@Composable
fun AudioPlayButton(
    textToSpeak: String,
    isCurrentlyPlaying: Boolean,
    onPlay: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    showSlowOption: Boolean = false
) {
    val infiniteTransition = rememberInfiniteTransition(label = "audio_pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isCurrentlyPlaying) 1.25f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Surface(
            shape = if (label != null) RoundedCornerShape(20.dp) else CircleShape,
            color = if (isCurrentlyPlaying) PrimaryIndigo else PrimaryIndigoLight,
            onClick = { onPlay(textToSpeak, false) },
            modifier = Modifier.testTag("audio_play_button")
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(
                    horizontal = if (label != null) 12.dp else 8.dp,
                    vertical = if (label != null) 6.dp else 8.dp
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.scale(if (isCurrentlyPlaying) pulseScale else 1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.VolumeUp,
                        contentDescription = "Listen English Pronunciation",
                        tint = if (isCurrentlyPlaying) Color.White else PrimaryIndigo,
                        modifier = Modifier.size(20.dp)
                    )
                }

                if (label != null) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (isCurrentlyPlaying) "Playing..." else label,
                        style = MaterialTheme.typography.labelMedium,
                        color = if (isCurrentlyPlaying) Color.White else PrimaryIndigo,
                        fontSize = 12.sp
                    )
                }
            }
        }

        if (showSlowOption) {
            Spacer(modifier = Modifier.width(6.dp))
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                onClick = { onPlay(textToSpeak, true) },
                modifier = Modifier.testTag("audio_slow_button")
            ) {
                Text(
                    text = "🐢 Slow",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    fontSize = 11.sp
                )
            }
        }
    }
}
