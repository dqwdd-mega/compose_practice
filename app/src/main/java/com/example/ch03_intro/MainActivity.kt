package com.example.ch03_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ch03_intro.ui.theme.Ch03IntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ch03IntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("zzzzzzzzzzz")
                    Column {
                        CardEx(cardData)
                        CardEx(cardData)
                    }
                }
            }
        }
    }

    companion object {
        val cardData = CardData(
            imageUri = "iVBORw0KGgoAAAANSUhEUgAAAAIAAAACCAYAAABytg0kAAAADUlEQVR42mP8/wcAAwAB/lnuNGwAAAAASUVORK5CYII=\n",
            imageDescription = "Go양이",
            author = "The Cat",
            description = "Go Yang yee"
        )
    }
}

@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            // Step 1
            // 이미지 넣고, 텍스트도 2개 넣고 간격도 넣는 예제
//            AsyncImage(
//                model = R.drawable.ic_launcher_background, // cardData.imageUri
//                contentDescription = cardData.imageDescription,
//                modifier = Modifier.size(32.dp)
//            )
//            Spacer(
//                modifier = Modifier.size(8.dp),
//            )
//            Column {
//                Text(
//                    text = cardData.author
//                )
//                Spacer(
//                    modifier = Modifier.size(4.dp)
//                )
//                Text(
//                    text = cardData.description
//                )
//            }

            // Step 2 - Step 1 의 이미지 둥글게
            AsyncImage(
                model = R.drawable.ic_launcher_background,
                contentScale = ContentScale.Crop,
                contentDescription = cardData.imageDescription,
                placeholder = ColorPainter(placeHolderColor),
                modifier = Modifier.size(32.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Spacer(
                modifier = Modifier.size(8.dp),
            )
            Column {
                Text(
                    text = cardData.author
                )
                Spacer(
                    modifier = Modifier.size(4.dp)
                )
                Text(
                    text = cardData.description
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Row {
        CardEx(MainActivity.cardData)
    }
}