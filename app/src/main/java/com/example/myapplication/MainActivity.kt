package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizScreen()
        }
    }
}

@Composable
fun QuizScreen() {
    var answer by remember { mutableStateOf<String?>(null) }
    val correctAnswer = "True" // Correct answer for the quiz

    MaterialTheme {  // Using MaterialTheme without external Theme.kt
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Is the Earth round?", style = MaterialTheme.typography.h5)

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Button(onClick = { answer = "True" }) {
                    Text("True")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { answer = "False" }) {
                    Text("False")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (answer != null) {
                Text(
                    text = "Your answer is $answer!",
                    color = if (answer == correctAnswer) MaterialTheme.colors.primary else MaterialTheme.colors.error
                )
            }
        }
    }
}
