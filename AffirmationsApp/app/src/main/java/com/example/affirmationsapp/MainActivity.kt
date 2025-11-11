package com.example.affirmationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(listOf(
                Affirmation(R.drawable.image1, "I am strong."),
                Affirmation(R.drawable.image2, "I believe in myself."),
                Affirmation(R.drawable.image3, "Each day is a new opportunity to grow and be a better version of myself."),
                Affirmation(R.drawable.image4, "Every challenge in my life is an opportunity to learn from."),
                Affirmation(R.drawable.image5, "I have so much to be grateful for."),
                Affirmation(R.drawable.image6, "Good things are always coming into my life."),
                Affirmation(R.drawable.image7, "New opportunities await me at every turn."),
                Affirmation(R.drawable.image8, "I have the courage to follow my heart."),
                Affirmation(R.drawable.image9, "Things will unfold at precisely the right time."),
                Affirmation(R.drawable.image10, "I will be present in all the moments that this day brings.")
            ))
        }
    }
}

data class Affirmation(val imageRes: Int, val text: String)

@Composable
fun App(affirmations: List<Affirmation>) {
    LazyColumn {
        items(affirmations) { affirmation ->
            Card(
                shape = RoundedCornerShape(25),
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(painterResource(affirmation.imageRes), null)
                    Spacer(Modifier.width(20.dp))
                    Text(affirmation.text)
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    App(listOf(
        Affirmation(R.drawable.image1, "I am strong."),
        Affirmation(R.drawable.image2, "I believe in myself."),
        Affirmation(R.drawable.image3, "Each day is a new opportunity to grow and be a better version of myself."),
        Affirmation(R.drawable.image4, "Every challenge in my life is an opportunity to learn from."),
        Affirmation(R.drawable.image5, "I have so much to be grateful for."),
        Affirmation(R.drawable.image6, "Good things are always coming into my life."),
        Affirmation(R.drawable.image7, "New opportunities await me at every turn."),
        Affirmation(R.drawable.image8, "I have the courage to follow my heart."),
        Affirmation(R.drawable.image9, "Things will unfold at precisely the right time."),
        Affirmation(R.drawable.image10, "I will be present in all the moments that this day brings.")
    ))
}
