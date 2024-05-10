package com.harkhark.feature.namelove

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun InputScreen(viewModel: InputViewModel = hiltViewModel()) {
//    Text(text = "InputScreen", modifier = Modifier.fillMaxSize())
    Row {
        Text("신윤학")
        Text("채여정")
        Button(onClick = {
            viewModel.initSample()
        }) {
            Text("계산하기")
        }
    }
}

//
//@Preview
//@Composable
