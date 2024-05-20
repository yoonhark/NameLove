package com.harkhark.feature.result

import androidx.lifecycle.viewModelScope
import com.harkhark.core.domain.usecase.CalcLoveUseCase
import com.harkhark.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val calcLoveUseCase: CalcLoveUseCase
): BaseViewModel() {
    private val _uiState = MutableStateFlow<ResultUiState>(ResultUiState.Loading)
    val uiState = _uiState.asStateFlow()
    fun calculateLove(sName: String, fName: String) {
        viewModelScope.launch {
            Timber.d("calculateLove : $sName $fName")
            calcLoveUseCase(sName,fName).collect{
                _uiState.value = ResultUiState.Success(it)
            }
        }
    }
}

sealed interface ResultUiState {
    data object Loading: ResultUiState
    data class Success(val result: String): ResultUiState
    data object Fail: ResultUiState
}