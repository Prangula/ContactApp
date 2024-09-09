package com.myapplication.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.myapplication.domain.model.ContactDomain
import com.myapplication.presentation.model.ContactUi
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val mapper: (ContactUi) -> ContactDomain,
    private val useCase: suspend (ContactDomain) -> Unit
) : ViewModel() {

    protected fun baseFun(item: ContactUi) {
        viewModelScope.launch {
            val mapItem = mapper(item)
            useCase(mapItem)
        }
    }

    abstract fun navController(navController: NavController, action: NavDirections)

    abstract fun popStackBack(
        navController: NavController,
        fragmentId: Int,
        boolean: Boolean
    )
}