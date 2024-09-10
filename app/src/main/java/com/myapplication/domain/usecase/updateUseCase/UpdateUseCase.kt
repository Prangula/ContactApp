package com.myapplication.domain.usecase.updateUseCase

import com.myapplication.domain.model.ContactDomain
import com.myapplication.domain.repository.ContactRepository
import com.myapplication.domain.usecase.base.BaseUseCase

class UpdateUseCase(private val contactRepository: ContactRepository) : BaseUseCase<
        ContactDomain,Unit>() {
    override suspend fun invoke(params: ContactDomain?) {
        contactRepository.update(params!!)
    }


}