package com.myapplication.domain.usecase.insertUseCase

import com.myapplication.domain.base.BaseUseCase
import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository

class InsertUseCase(private var contactRepository: ContactRepository) : BaseUseCase
<ContactDomain, Unit>() {
    override suspend fun invoke(params: ContactDomain?) {
        contactRepository.insert(params!!)
    }
}