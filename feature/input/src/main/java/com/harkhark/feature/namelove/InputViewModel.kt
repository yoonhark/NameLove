package com.harkhark.feature.namelove

import androidx.lifecycle.viewModelScope
import com.harkhark.core.domain.usecase.CalcLoveUseCase
import com.harkhark.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val getSampleUseCase: CalcLoveUseCase
): BaseViewModel() {
    var text:String? = null

    fun initSample() {
        viewModelScope.launch {
            getSampleUseCase("Shin","Char").collect{
                text = it
            }
        }
    }
}