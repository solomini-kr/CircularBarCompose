package kr.mad.circularbarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.mad.circularbarcompose.components.CircularBar
import kr.mad.circularbarcompose.ui.theme.CircularBarComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularBarComposeTheme {

                var progress by remember { mutableStateOf(0f) }

                Column(Modifier.padding(64.dp))
                {

                    // 애니메이션 효과
                    val animProgress by animateFloatAsState( progress,
                        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                    )

                    val circularBar1 = CircularBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.0f),
                        progress = animProgress,
                        progressMax = 45f,
                        progressBarColor = Color.Red,
                        progressBarWidth = 10.dp,
                        backgroundProgressBarColor = Color.Gray.copy(alpha = 0.2f),
                        backgroundProgressBarWidth = 10.dp,
                        roundBorder = true,
                        startAngle = 0f,
                        text = "41 kWh",
                        fontColor = Color.Black
                    )

                    LaunchedEffect(true) {
                        progress = 41f
                    }
                }
            }
        }


    }
}

