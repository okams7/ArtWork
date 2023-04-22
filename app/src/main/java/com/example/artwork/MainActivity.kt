package com.example.artwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artwork.ui.theme.ArtWorkTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtWorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var currentSelection by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(shadowElevation = 4.dp) {
            ArtImage(R.drawable.contempary_art)
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Surface(shadowElevation = 4.dp) {
            Column(modifier = Modifier.padding(8.dp)) {
                ArtTitle("Title may be long so be carefully it might be so long")
                Row {
                    ArtistName("artist name")
                    Spacer(modifier = Modifier.padding(2.dp))
                    ArtYear("2023")
                }

            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {}) {
                Text(text = "Previous")
            }
            Button(onClick = {}) {
                Text(text = "Next")
            }

        }
    }
}

@Composable
fun ArtImage(imgId: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .border(4.dp, Color.Gray)
            .fillMaxHeight(0.75f),
//                    .height(height = 540.dp),
        painter = painterResource(id = imgId),
        contentScale = ContentScale.Fit,
        contentDescription = stringResource(id = R.string.app_name),
    )
}

@Composable
fun ArtTitle(label: String){
    Text(
        text = label,
        fontSize = 20.sp
    )
}

@Composable
fun ArtistName(label: String){
    Text(label, fontWeight = FontWeight.Bold)
}

@Composable
fun ArtYear(label: String){
    Text(text = "($label)")
}

fun changingStatus(cst: Int) {
    when (cst) {
        1 -> print("")
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ArtWorkTheme {
        MainScreen()
    }
}