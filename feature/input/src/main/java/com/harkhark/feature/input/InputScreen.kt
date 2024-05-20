package com.harkhark.feature.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun InputScreen(onCalcClick: (String, String) -> Unit) {
    var sName by remember { mutableStateOf("") }
    var fName by remember { mutableStateOf("") }

    val viewModel: InputViewModel = hiltViewModel()

    Column {
        OutlinedTextField(
            value = sName,
            onValueChange = { sName = it },
            label = { Text("sName") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fName,
            onValueChange = { fName = it },
            label = { Text("fName") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                onCalcClick(sName, fName)
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Text("Calculate")
        }
    }
}

//
//@Preview
//@Composable
