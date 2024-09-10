package com.myapplication.presentation.screen.updateScreen.vm

import com.myapplication.domain.usecase.updateUseCase.UpdateUseCase
import com.myapplication.presentation.base.BaseViewModel
import com.myapplication.presentation.mapper.ContactUiToDomainMapper
import com.myapplication.presentation.model.ContactUi

class UpdateViewModel(
    private val updateUseCase: UpdateUseCase,
    private val contactUiToDomainMapper: ContactUiToDomainMapper
) : BaseViewModel(
    mapper = contactUiToDomainMapper::mapModel,
    useCase = { updateUseCase(it) }
) {

    fun update(contactUi: ContactUi) {
        baseFun(contactUi)
    }
}