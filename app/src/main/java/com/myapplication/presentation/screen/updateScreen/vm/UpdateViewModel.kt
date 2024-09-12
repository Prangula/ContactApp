package com.myapplication.presentation.screen.updateScreen.vm

import com.myapplication.domain.usecase.updateUseCase.UpdateUseCase
import com.myapplication.presentation.base.BaseViewModel
import com.myapplication.presentation.mapper.ContactUiToDomainMapper
import com.myapplication.presentation.model.ContactUi
import com.myapplication.utils.viewModelScope

class UpdateViewModel(
    private val updateUseCase: UpdateUseCase,
    private val contactUiToDomainMapper: ContactUiToDomainMapper
) : BaseViewModel() {

    fun update(contactUi: ContactUi) {
        val mappedItem = contactUiToDomainMapper.mapModel(contactUi)
        viewModelScope {
            updateUseCase(mappedItem)
        }
    }
}