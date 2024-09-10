package com.myapplication.domain.usecase.insertUseCase

import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository

class InsertUseCaseImpl(private var contactRepository: ContactRepository) : InsertUseCase {

    override suspend operator fun invoke(contactDomain: ContactDomain) {
        contactRepository.insert(contactDomain)
    }
}