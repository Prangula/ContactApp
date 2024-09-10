package com.myapplication.domain.usecase.updateUseCase

import com.myapplication.domain.base.BaseUseCase
import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository

class UpdateUseCase(private val contactRepository: ContactRepository) : BaseUseCase
<ContactDomain, Unit>() {
    override suspend fun invoke(params: ContactDomain?) {
        contactRepository.update(params!!)
    }
}