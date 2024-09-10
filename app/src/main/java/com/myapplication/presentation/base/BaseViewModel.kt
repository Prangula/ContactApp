package com.myapplication.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.myapplication.domain.model.ContactDomain
import com.myapplication.presentation.model.ContactUi
import com.myapplication.utils.NavigationCommand
import com.myapplication.utils.extension
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val mapper: (ContactUi) -> ContactDomain,
    private val useCase: suspend (ContactDomain) -> Unit
) : ViewModel() {

    private val _navigation = MutableStateFlow<NavigationCommand?>(null)
    val navigation = _navigation.asStateFlow()


    protected fun baseFun(item: ContactUi) {
        extension(item, mapper, useCase)
    }

    fun navController(action: NavDirections) {
        viewModelScope.launch {
            _navigation.value = NavigationCommand.ToDirection(action)
        }
    }

    fun backNavigation() {
        viewModelScope.launch {
            _navigation.value = NavigationCommand.Back
        }
    }
}