package com.hakrhark.feature.splash

import androidx.lifecycle.viewModelScope
import com.harkhark.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

): BaseViewModel() {

    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.Ready)
    val uiState = _uiState.asStateFlow()

    init {
        initSplash()
    }

    private fun initSplash(){
        _uiState.value = SplashUiState.Loading
        viewModelScope.launch {
            delay(2000)
            _uiState.value = SplashUiState.Success
        }
    }
}

sealed interface SplashUiState {
    data object Ready: SplashUiState
    data object Loading: SplashUiState
    data object Success: SplashUiState
}