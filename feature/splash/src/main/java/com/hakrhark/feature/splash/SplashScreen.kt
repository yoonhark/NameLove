package com.hakrhark.feature.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.harkhark.core.ui.annotation.DevicePreviews

@Composable
fun SplashScreen(navigateToInput: () -> Unit) {
    val viewModel: SplashViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    if(uiState is SplashUiState.Success) {
        navigateToInput()
    }
    SplashView(uiState)
}

@Composable
fun SplashView(uiState: SplashUiState) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Splash Screen",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = when (uiState) {
                    is SplashUiState.Ready -> "Ready"
                    is SplashUiState.Success -> "Success"
                    else -> "Loading"
                },
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}


@DevicePreviews
@Composable
fun SplashScreenPreview() {
    SplashView(SplashUiState.Ready)
}