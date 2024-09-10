package com.myapplication.domain.usecase.updateUseCase

import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository

class UpdateUseCaseImpl(private val contactRepository: ContactRepository) : UpdateUseCase {

    override suspend operator fun invoke(contactDomain: ContactDomain) {
        contactRepository.update(contactDomain)
    }
}