package com.myapplication.domain.usecase.deleteUseCase.useCaseImpl

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.repository.ContactRepository
import com.myapplication.domain.usecase.deleteUseCase.useCase.DeleteUseCase

class DeleteUseCaseImpl(private var contactRepository: ContactRepository) : DeleteUseCase {

    override suspend operator fun invoke(contactEntity: ContactEntity) {
        contactRepository.delete(contactEntity)
    }
}