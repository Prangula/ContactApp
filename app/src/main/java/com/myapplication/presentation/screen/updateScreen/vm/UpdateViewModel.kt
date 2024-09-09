package com.myapplication.presentation.screen.updateScreen.vm

import androidx.navigation.NavController
import androidx.navigation.NavDirections
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

    override fun navController(navController: NavController, action: NavDirections) {
        navController.navigate(action)
    }

    override fun popStackBack(navController: NavController, fragmentId: Int, boolean: Boolean) {
        navController.popBackStack(fragmentId,boolean)
    }
}