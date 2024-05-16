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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting()
//                    Column {
//                        TextFieldTheme()
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var name by remember { mutableStateOf("Tom") }
    Column(modifier = Modifier.padding(16.dp)) {
        // Step 1: TextField 를 Text 위에 만듭니다
        // value 와 onValueChanged 는 비워둡시다
//        TextField(value = "Tom", onValueChange = {})

        // Step 2: Text 에 Android 대신 TextField 입력을
        // 출력하게 합시다. mutableStateOf("") 필드를 하나 만듭시다.
//        TextField(
//            value = name,
//            onValueChange = {
//                name = it
//            }
//        )

        // Step 3: TextField 에 label 을 추가합시다.
        // 내용에는 'Text("Name)'을 채워봅시다.
//        TextField(
//            value = name,
//            label = {
//                Text(text = "rladlkim name")
//            },
//            onValueChange = {
//                name = it
//            }
//        )

        // Step 4: TextField 와 Text 사이에 Spacer 를 넣어 8.에 간격을 줍시다
        TextField(
            value = name,
            label = {
                Text(text = "rladlkim name")
            },
            onValueChange = {
                name = it
            }
        )
        Spacer(modifier = Modifier.size(8.dp))

        // Step 5: TextField 를 OutlinedTextField 로 변경해봅시다

        Text(text = "Hello $name")
    }
}

@Composable
fun TextFieldTheme() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hello Android"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Row {
        TextFieldTheme()
    }
}