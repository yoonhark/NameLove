package com.harkhark.feature.result

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ResultScreen(sName: String, fName: String) {
    val viewModel: ResultViewModel = hiltViewModel()
    viewModel.calculateLove(sName, fName)

    val uiState by viewModel.uiState.collectAsState()
    Text(
        text = when (uiState) {
            is ResultUiState.Success -> {
                (uiState as ResultUiState.Success).result
            }

            else -> "Result Screen"
        },
        modifier = Modifier.fillMaxWidth(),

    )
}