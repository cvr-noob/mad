package com.example.unscrambleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<GameVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App(viewModel)
        }
    }
}

@Composable
fun App(viewModel: GameVM) {
    val word by viewModel.scrambledWord.observeAsState("")
    val score by viewModel.score.observeAsState(0)
    var guess by remember { mutableStateOf("") }

    Column {
        Text("Unscramble this word:")
        Text(word)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = guess,
            onValueChange = { guess = it },
            label = { Text("Your guess") },
            enabled = word != "Game Over!"
        )
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            viewModel.checkGuess(guess)
            guess = ""
        }, enabled = word != "Game Over!") { Text("Submit") }
        Spacer(Modifier.height(8.dp))
        Text("Score: $score")
    }
}
