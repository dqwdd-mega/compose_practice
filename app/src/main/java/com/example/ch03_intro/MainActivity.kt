package com.example.ch03_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
                        CheckBoxEx()
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
//        var checked = false
//        Checkbox(
//            checked = checked,
//            onCheckedChange = { // 바뀔 때 로직
//                checked = !checked
//            }
//        )

        // Step 3: boolean 대신 remember { mutableStateOf(false) }를
        // 사용하여 상태를 도입합시다(value 프로퍼티를 이용해야 합니다)
//        val checked = remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { // 바뀔 때 로직
//                checked.value = !checked.value
//            }
//        )

        // Step 4: delegated properties 로 변경해봅시다
        // 위임된 속성
        // checked 가 프로퍼티인 것처럼 사용할 수 있다
        // by 를 써서, check 가 mutableStateOf 값에 .value 를 붙인 값인 것마냥~
//        var checked by remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked,
//            onCheckedChange = { // 바뀔 때 로직
//                checked = !checked
//            }
//        )

        // Step 5: destruction 으로 상태를 받아서 사용해봅시다
        val (checked, setChecked) = remember { mutableStateOf(false) }
        Checkbox(
            checked = checked,
            onCheckedChange = setChecked
        )


        // Checkbox 를 앞에 넣어주세요
        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                setChecked(!checked)
            }
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