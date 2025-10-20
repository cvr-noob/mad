package com.example.lifecycleapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lifecycleapp.ui.theme.LifecycleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text("Hello World")
            Log.d("mytag", "onCreate called")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("mytag", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mytag", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("mytag", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mytag", "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mytag", "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mytag", "onDestroy called")
    }
}
