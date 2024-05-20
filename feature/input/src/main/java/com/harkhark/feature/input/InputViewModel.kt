package com.harkhark.feature.input

import androidx.lifecycle.viewModelScope
import com.harkhark.core.domain.usecase.CalcLoveUseCase
import com.harkhark.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(

): BaseViewModel() {
    var text:String? = null


}