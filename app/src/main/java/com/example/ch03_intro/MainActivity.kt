package com.example.ch03_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
//                        CheckBoxEx(cardData)
                    }
                }
            }
        }
    }

}

@Composable
fun CheckBoxEx() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Step 1: Create Checkbox - checked 속성은 false
        // onCheckedChange 는 비워둡시다
//        Checkbox(
//            checked = false,
//            onCheckedChange = { // 바뀔 때 로직

//            }
//        )

        // Step 2: onCheckedChange 에서 boolean 값 변수를 바꾸고
        // checked 에서 그 값을 반영해봅시다(잘 되지 않습니다)
        var checked = false
        Checkbox(
            checked = checked,
            onCheckedChange = { // 바뀔 때 로직
                checked = !checked
            }
        )

        // Step 3: boolean 대신 remember { mutableStateOf(false) }를
        // 사용하여 상태를 도입합시다(value 프로퍼티를 이용해야 합니다)

        // Step 4: delegated properties 로 변경해봅시다

        // Step 5: destruction 으로 상태를 받아서 사용해봅시다

        // Checkbox 를 앞에 넣어주세요
        Text(
            text = "프로그래머입니까?"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Row {
        CheckBoxEx()
    }
}