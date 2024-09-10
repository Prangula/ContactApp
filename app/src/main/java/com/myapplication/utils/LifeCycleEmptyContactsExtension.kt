package com.myapplication.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow

fun <T> LifecycleOwner.emptyObserve(
    stateFlow: Flow<T>, // Flow და არა stateFlow
    isEmpty: (T) -> Unit
) {
    lifecycleScope.launchWhenStarted {
        stateFlow.collect { emptyContacts ->
            isEmpty(emptyContacts)
        }
    }
}