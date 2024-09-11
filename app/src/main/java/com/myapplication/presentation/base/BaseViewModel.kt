package com.myapplication.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.myapplication.utils.NavigationCommand
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _navigation = MutableSharedFlow<NavigationCommand?>()
    val navigation = _navigation.asSharedFlow()

    fun navigateTo(action: NavDirections) {
        viewModelScope.launch {
            _navigation.emit(NavigationCommand.ToDirection(action))
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _navigation.emit(NavigationCommand.Back)
        }
    }
}