package com.myapplication.domain.usecase.deleteUseCase

import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository
import com.myapplication.domain.usecase.base.BaseUseCase

class DeleteUseCase(private var contactRepository: ContactRepository) :
    BaseUseCase<ContactDomain, Unit>() {
    override suspend fun invoke(params: ContactDomain?) {
        contactRepository.delete(params!!)
    }
}