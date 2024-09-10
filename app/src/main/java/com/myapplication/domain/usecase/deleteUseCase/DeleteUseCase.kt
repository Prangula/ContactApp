package com.myapplication.domain.usecase.deleteUseCase

import com.myapplication.domain.model.ContactDomain

interface DeleteUseCase {
    suspend operator fun invoke(contactDomain: ContactDomain)
}