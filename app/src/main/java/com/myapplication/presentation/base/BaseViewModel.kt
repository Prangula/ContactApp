package com.myapplication.presentation.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.myapplication.utils.NavigationCommand
import com.myapplication.utils.navigateBack
import com.myapplication.utils.navigateTo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

abstract class BaseViewModel : ViewModel() {

    private val _navigation = MutableSharedFlow<NavigationCommand>()
    val navigation: SharedFlow<NavigationCommand> get() = _navigation

    fun navigateTo(action: NavDirections) {
        navigateTo(_navigation, action)
    }

    fun navigateBack() {
        navigateBack(_navigation)
    }
}