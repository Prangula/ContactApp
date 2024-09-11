package com.myapplication.presentation.screen.insertScreen.vm

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputLayout
import com.myapplication.domain.usecase.insertUseCase.InsertUseCase
import com.myapplication.presentation.base.BaseViewModel
import com.myapplication.presentation.mapper.ContactUiToDomainMapper
import com.myapplication.presentation.model.ContactUi
import com.myapplication.utils.viewModelExtension
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InsertViewModel(
    private val insertUseCase: InsertUseCase,
    private val contactUiToDomainMapper: ContactUiToDomainMapper,
) : BaseViewModel() {

    fun insert(contactUi: ContactUi) {
        viewModelExtension(
            item = contactUi,
            mapper = { contactUiToDomainMapper.mapModel(it) },
            useCase = { insertUseCase }
        )
    }

    fun insertError(
        input1: TextInputLayout,
        input2: TextInputLayout,
        red: Int,
        white: Int,
        context: Context
    ) {
        input1.background =
            ContextCompat.getDrawable(
                context,
                red
            )
        input2.background =
            ContextCompat.getDrawable(
                context,
                red
            )
        viewModelScope.launch {
            delay(1500)
            input1.background =
                ContextCompat.getDrawable(
                    context,
                    white
                )
            input2.background =
                ContextCompat.getDrawable(
                    context,
                    white
                )
        }
    }
}