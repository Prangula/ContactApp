package com.myapplication.domain.usecase.contactsUseCase

import com.myapplication.domain.model.ContactDomain
import kotlinx.coroutines.flow.Flow

interface ContactsUseCase {
    suspend operator fun invoke(): Flow<List<ContactDomain>>
}