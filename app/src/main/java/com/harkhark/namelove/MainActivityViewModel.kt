package com.harkhark.namelove

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
//    private val calcLoveUseCase: CalcLoveUseCase
): ViewModel(){
    val uiState = MutableStateFlow<MainActivityUiState>(MainActivityUiState.Loading)

    fun load() {
        uiState.value = MainActivityUiState.Success
    }
}


sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data object Success : MainActivityUiState
}
