package com.myapplication.domain.usecase.deleteUseCase

import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository

class DeleteUseCaseImpl(private var contactRepository: ContactRepository) : DeleteUseCase {

    override suspend operator fun invoke(contactDomain: ContactDomain) {
        contactRepository.delete(contactDomain)
    }
}