package com.myapplication.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.StateFlow

fun <T> LifecycleOwner.observe(
    stateFlow: StateFlow<T>,
    action: (T) -> Unit
) {
    lifecycleScope.launchWhenStarted {
        stateFlow.collect { item ->
            action(item)
        }
    }
}