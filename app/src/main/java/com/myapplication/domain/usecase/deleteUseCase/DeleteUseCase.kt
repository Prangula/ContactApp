package com.myapplication.domain.usecase.deleteUseCase

import com.myapplication.domain.base.BaseUseCase
import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository

class DeleteUseCase(private var contactRepository: ContactRepository) : BaseUseCase
<ContactDomain, Unit>() {
    override suspend fun invoke(params: ContactDomain?) {
        contactRepository.delete(params!!)
    }
}