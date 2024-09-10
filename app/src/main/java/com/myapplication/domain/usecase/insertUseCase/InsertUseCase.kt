package com.myapplication.domain.usecase.insertUseCase

import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository
import com.myapplication.domain.usecase.base.BaseUseCase

class InsertUseCase(private var contactRepository: ContactRepository) :
    BaseUseCase<ContactDomain, Unit>() {
    override suspend fun invoke(params: ContactDomain?) {
        contactRepository.insert(params!!)
    }
}