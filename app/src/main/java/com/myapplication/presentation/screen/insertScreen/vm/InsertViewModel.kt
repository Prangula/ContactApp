package com.myapplication.presentation.screen.insertScreen.vm

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputLayout
import com.myapplication.domain.domainMapper.ContactUiMapper
import com.myapplication.domain.usecase.insertUseCase.InsertUseCase
import com.myapplication.presentation.model.ContactUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InsertViewModel(
    private val insertUseCase: InsertUseCase,
    private val contactUiMapper: ContactUiMapper
) : ViewModel() {

    fun insert(contactUi: ContactUi) {
        viewModelScope.launch {
            val item = contactUiMapper.reverse(contactUi)
            insertUseCase(item)
        }
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