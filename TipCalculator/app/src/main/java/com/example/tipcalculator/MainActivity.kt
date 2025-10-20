package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var bill by remember { mutableStateOf(TextFieldValue("")) }
    var percent by remember { mutableStateOf(TextFieldValue("")) }
    var tip by remember { mutableStateOf(0.0) }

    fun calcTip(bill: Double, percent: Double) = bill * percent / 100

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(bill, { bill = it }, label = { Text("Bill Amount") })
        Spacer(Modifier.height(8.dp))
        TextField(percent, { percent = it }, label = { Text("Tip %") })
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            tip = calcTip(bill.text.toDoubleOrNull() ?: 0.0, percent.text.toDoubleOrNull() ?: 0.0)
        }) {
            Text("Calculate")
        }
        Spacer(Modifier.height(16.dp))
        Text("Tip: $tip")
    }
}
