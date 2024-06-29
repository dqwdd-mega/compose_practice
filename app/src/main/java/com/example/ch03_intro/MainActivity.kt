@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ch03_intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.ch03_intro.ui.theme.ConstraintLayoutSet

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutSet {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintSetEx()
                }
            }
        }
    }
}


@Composable
fun ConstraintSetEx() {
    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox) {
            bottom.linkTo(parent.bottom, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(greenBox) {
            centerTo(parent)
        }

        constrain(yellowBox) {
            start.linkTo(greenBox.end)
            top.linkTo(greenBox.bottom)
        }
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
//        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        // red
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
        )

        // magenta
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
        )

        // green
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
        )

        // yellow
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    ConstraintLayoutSet {
        ConstraintSetEx()
    }
}