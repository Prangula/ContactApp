package com.myapplication.utils


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.myapplication.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.Flow

fun <T> LifecycleOwner.observe(
    flow: Flow<T>,
    action: (T) -> Unit
) {
    lifecycleScope.launch {
        flow.collect { data ->
            action(data)
        }
    }
}

fun <T> ViewModel.viewModelScope(
    item: T,
    action: suspend (T) -> Unit
) {
    viewModelScope.launch {
        action(item)
    }
}

fun BaseViewModel.navigateTo(
    navigationFlow: MutableSharedFlow<NavigationCommand>,
    action: NavDirections
) {
    viewModelScope.launch {
        navigationFlow.emit(NavigationCommand.ToDirection(action))
    }
}

fun BaseViewModel.navigateBack(navigationFlow: MutableSharedFlow<NavigationCommand>) {
    viewModelScope.launch {
        navigationFlow.emit(NavigationCommand.Back)
    }
}