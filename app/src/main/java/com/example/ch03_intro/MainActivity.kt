package com.example.ch03_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ch03_intro.ui.theme.Ch03IntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ch03IntroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatalogEx(items)
                }
            }
        }
    }
}

@Composable
fun Item(itemData: ItemData) {
    // Step 1: catalog1.png 를 참고해 카드 레이아웃을 완성하세요
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = itemData.title
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Text(
                text = itemData.description,
            )
        }
    }
}

@Composable
fun CatalogEx(itemList: List<ItemData>) {
    LazyColumn {
        // Step 2: 'items(itemList)' 를 이용해 Item 을 반복해서 컬럼에 추가하세요
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    Ch03IntroTheme {
        Item(
            ItemData(
                imageId = R.drawable.a1,
                title = "해변 놀이 공워언",
                description = "해변 놀이 공워언 설명"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    Ch03IntroTheme {
        CatalogEx(itemList = items)
    }
}

data class ItemData(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String
)

val items = listOf(
    ItemData(
        imageId = R.drawable.a1,
        title = "김해변",
        description = "김설명"
    )
)