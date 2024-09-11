package com.myapplication.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.emptyObserveExtension(
    flow: Flow<T>,
    isEmpty: (T) -> Unit
) {
    lifecycleScope.launchWhenStarted {
        flow.collect { emptyContacts ->
            isEmpty(emptyContacts)
        }
    }
}

fun <VM : ViewModel, T, R> VM.viewModelExtension(
    item: T,
    mapper: (T) -> R,
    useCase: suspend (R) -> Unit
) {
    viewModelScope.launch {
        val mappedItem = mapper(item)
        useCase(mappedItem)
    }
}