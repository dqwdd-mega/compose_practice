@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ch03_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ch03_intro.ui.theme.Ch03IntroTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ch03IntroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlotEx()
                }
            }
        }
    }
}

// Step 1: 'Row' 를 '@Composable' 함수로 분리합시다
// 'checked' 의 값, 'Text' 의 'text' 를 인자로 전달합시다

/// 같은 기능을 가졌는데 반복되고 있으니 묶어서 컴포저블 함수로 쓰자~
//@Composable
//fun CheckBoxWithText(checked: MutableState<Boolean>, text: String) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
//    }
//}


// Step 2: '@Composable' 함수에서 '@Composable () -> Unit' 타입으로
// 'content' 를 받아옵시다. 'Row' 의 'Text' 를 빼고 'content()' 를 넣읍시다.
// 'Row' 에 'Modifier.clickable' 를 넣어 전체를 클릭 가능하게 합시다

/// 이게 진정한 Slot API 라고 할 수 있거든요~
/// 그리고 Slot API 를 만들 땐 보통 마지막 인자로 content 를 넣는 편이다
/// 왜냐하면 마지막 인자로 만들어야 호출할 때 {} 이렇게 사용할 수 있기 때문(그게 보기 좋으니까)
/// 람다에 @Composable 도 붙여줘야 한다
@Composable
fun CheckBoxWithSlotAPI(
    checked: MutableState<Boolean>,
    content: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            checked.value = !checked.value
        }
    ) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = { checked.value = it }
        )
        content()
    }
}

// Step 3: 'content' 의 타입을 '@Composable RowScope.() -> Unit' 로 바꿉시다.
// 이렇게 다른 콤포저블 컨텐트를 넣는 방식을 Slot API 라 합니다.

// Step 4: 상태를 바꾸는 람다를 '@Composable' 함수의 인자로 뺍시다.
// 인자에서 MutableState 대신 boolean 값으로 변경합시다.

@Composable
fun SlotEx() {
    val checked1 = remember { mutableStateOf(false) }
    val checked2 = remember { mutableStateOf(false) }

    Column {
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Checkbox(
//                checked = checked1.value,
//                onCheckedChange = { checked1.value = it }
//            )
//            Text(
//                text = "텍스트-1",
//                modifier = Modifier.clickable { checked1.value = !checked1.value }
//            )
//        }

//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Checkbox(
//                checked = checked2.value,
//                onCheckedChange = { checked2.value = it }
//            )
//            Text(
//                text = "텍스트-2",
//                modifier = Modifier.clickable { checked2.value = !checked2.value }
//            )
//        }

        CheckBoxWithSlotAPI(checked1) {
            Text("텍스트-11")
        }
        CheckBoxWithSlotAPI(checked2) {
            Text("텍스트-22")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    Ch03IntroTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SlotEx()
        }
    }
}