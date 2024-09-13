package com.myapplication.domain.base

abstract class BaseUseCase<in Params, out T> {
    abstract suspend operator fun invoke(params: Params? = null): T
}