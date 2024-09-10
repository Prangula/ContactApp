package com.myapplication.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

fun <VM : ViewModel, T, R> VM.extension(
    item: T,
    mapper: (T) -> R,
    useCase: suspend (R) -> Unit
) {
    viewModelScope.launch {
        val mappedItem = mapper(item)
        useCase(mappedItem)
    }
}