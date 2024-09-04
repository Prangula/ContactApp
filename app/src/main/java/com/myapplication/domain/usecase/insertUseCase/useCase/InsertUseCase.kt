package com.myapplication.domain.usecase.insertUseCase.useCase

import com.myapplication.data.local.entity.ContactEntity

interface InsertUseCase {
    suspend operator fun invoke(contactEntity: ContactEntity)
}