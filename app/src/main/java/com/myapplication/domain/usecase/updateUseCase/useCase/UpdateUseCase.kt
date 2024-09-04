package com.myapplication.domain.usecase.updateUseCase.useCase

import com.myapplication.data.local.entity.ContactEntity

interface UpdateUseCase {
    suspend operator fun invoke(contactEntity: ContactEntity)
}