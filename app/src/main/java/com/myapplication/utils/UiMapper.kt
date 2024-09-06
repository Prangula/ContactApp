package com.myapplication.utils

interface UiMapper<in MODEL_A, out MODEL_B> {
    operator fun invoke(model: MODEL_A): MODEL_B
    fun reverse (model: @UnsafeVariance MODEL_B): @UnsafeVariance MODEL_A
}