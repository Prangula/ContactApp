package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Update
import com.myapplication.domain.use_cases.ContactsUseCase
import com.myapplication.domain.use_cases.DeleteUseCase
import com.myapplication.domain.use_cases.InsertUseCase
import com.myapplication.domain.use_cases.UpdateUseCase

class DeleteViewModelFactory(private val deleteUseCase: DeleteUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DeleteViewModel(deleteUseCase) as T
    }
}