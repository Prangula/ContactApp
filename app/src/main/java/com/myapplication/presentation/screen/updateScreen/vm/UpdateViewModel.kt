package com.myapplication.presentation.screen.updateScreen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.domain.usecase.updateUseCase.UpdateUseCase
import com.myapplication.presentation.mapper.ContactUiToDomainMapper
import com.myapplication.presentation.model.ContactUi
import kotlinx.coroutines.launch

class UpdateViewModel(
    private val updateUseCase: UpdateUseCase,
    private val contactUiToDomainMapper: ContactUiToDomainMapper
) :
    ViewModel() {

    fun update(contactUi: ContactUi) {
        viewModelScope.launch {
            val item = contactUiToDomainMapper.mapModel(contactUi)
            updateUseCase(item)
        }
    }
}