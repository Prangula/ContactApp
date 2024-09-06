package com.myapplication.presentation.screen.updateScreen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.domain.domainMapper.ContactUiMapper
import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.usecase.updateUseCase.UpdateUseCase
import com.myapplication.presentation.model.ContactUi
import kotlinx.coroutines.launch

class UpdateViewModel(
    private val updateUseCase: UpdateUseCase,
    private val contactUiMapper: ContactUiMapper
) :
    ViewModel() {

    fun update(contactUi: ContactUi) {
        viewModelScope.launch {
            val item = contactUiMapper.reverse(contactUi)
            updateUseCase(item)
        }
    }
}