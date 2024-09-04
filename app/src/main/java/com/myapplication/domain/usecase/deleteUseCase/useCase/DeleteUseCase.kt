package com.myapplication.domain.usecase.deleteUseCase.useCase

import com.myapplication.data.local.entity.ContactEntity

interface DeleteUseCase {
    suspend operator fun invoke(contactEntity: ContactEntity)
}