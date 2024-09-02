package com.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Update
import com.myapplication.domain.use_cases.ContactsUseCase
import com.myapplication.domain.use_cases.InsertUseCase
import com.myapplication.domain.use_cases.UpdateUseCase

class UpdateViewModelFactory(private val updateUseCase: UpdateUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return UpdateViewModel(updateUseCase) as T
    }
}