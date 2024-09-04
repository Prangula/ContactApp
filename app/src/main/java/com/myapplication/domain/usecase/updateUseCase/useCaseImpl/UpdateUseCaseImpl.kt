package com.myapplication.domain.usecase.updateUseCase.useCaseImpl

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.repository.ContactRepository
import com.myapplication.domain.usecase.updateUseCase.useCase.UpdateUseCase

class UpdateUseCaseImpl(private val contactRepository: ContactRepository) : UpdateUseCase {

    override suspend operator fun invoke(contactEntity: ContactEntity) {
        contactRepository.update(contactEntity)
    }
}