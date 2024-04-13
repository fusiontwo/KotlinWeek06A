package com.example.week06a.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun RandomColorButton() {
    val scope = rememberCoroutineScope()
    var color by remember { mutableStateOf(Color.Red) }

    Column {
        Button(
            onClick = {
                scope.launch {
                    while (true) {
                        delay(500)  // 0.5초 지난 후
                        color = Color(
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            0xFF
                        )
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(color)  // 컬러 변경
        ) {
            Text("Change Color")
        }
    }
}

@Composable
fun RandomColorButton2() {
    val scope = rememberCoroutineScope()
    var color by remember { mutableStateOf(Color.Red) }

    Column {
        Button(
            onClick = {
               val job = scope.launch {
                    while (true) {
                        delay(500)
                        color = Color(
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            0xFF
                        )
                    }
                }

                scope.launch {
                    delay(2000)  // 2초 후에
                    job.cancel()  // 종료
                }
            },
            colors = ButtonDefaults.buttonColors(color)
        ) {
            Text("Change Color")
        }
    }
}

@Preview
@Composable
private fun RandomColorButtonPreview() {
    Column {
        RandomColorButton()
        RandomColorButton2()
    }

}