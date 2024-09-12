package com.myapplication.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
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

fun ViewModel.viewModelScope(
    action: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch { action() }
}

fun LifecycleOwner.lifeCycleScope(
    action: suspend CoroutineScope.() -> Unit
) {
    lifecycleScope.launch { action() }
}
