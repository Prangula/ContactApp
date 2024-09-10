package com.myapplication.domain.usecase.insertUseCase

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.model.ContactDomain

interface InsertUseCase {
    suspend operator fun invoke(contactDomain: ContactDomain)
}