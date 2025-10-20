package com.example.dictionaryapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictionaryapp.ui.theme.DictionaryAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var showMenu by remember { mutableStateOf(false) }

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Dictionary") },
                        actions = {
                            IconButton({
                                showMenu = !showMenu
                            }) { Icon(Icons.Default.Menu, "") }
                            DropdownMenu(
                                expanded = showMenu, onDismissRequest = { showMenu = false }
                            ) {
                                DropdownMenuItem(
                                    { Text("About") },
                                    {
                                        startActivity(Intent(this@MainActivity, AboutActivity::class.java))
                                    }
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                App(Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Word: Kotlin")
        Text("Meaning: A modern programming language.")
        Spacer(Modifier.height(16.dp))
        Text("Word: Android")
        Text("Meaning: A modern OS for mobile phones.")
        Spacer(Modifier.height(16.dp))
        Text("Word: Java")
        Text("Meaning: An object-oriented programming language.")
    }
}
