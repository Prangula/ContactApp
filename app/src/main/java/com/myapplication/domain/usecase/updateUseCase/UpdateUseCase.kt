package com.myapplication.domain.usecase.updateUseCase

import com.myapplication.domain.model.ContactDomain

interface UpdateUseCase {
    suspend operator fun invoke(contactDomain: ContactDomain)
}