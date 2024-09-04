package com.myapplication.domain.usecase.insertUseCase.useCaseImpl

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.repository.ContactRepository
import com.myapplication.domain.usecase.insertUseCase.useCase.InsertUseCase

class InsertUseCaseImpl(private var contactRepository: ContactRepository) : InsertUseCase {

    override suspend operator fun invoke(contactEntity: ContactEntity) {
        contactRepository.insert(contactEntity)
    }
}