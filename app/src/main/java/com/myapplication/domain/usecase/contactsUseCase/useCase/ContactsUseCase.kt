package com.myapplication.domain.usecase.contactsUseCase.useCase

import com.myapplication.data.local.entity.ContactEntity
import kotlinx.coroutines.flow.Flow

interface ContactsUseCase {
    suspend operator fun invoke(): Flow<List<ContactEntity>>
}