package com.myapplication.presentation.mapper

import com.myapplication.domain.model.ContactDomain
import com.myapplication.presentation.model.ContactUi
import com.myapplication.utils.UiMapper

class ContactUiToDomainMapper : UiMapper<ContactUi, ContactDomain> {
    override fun mapModel(model: ContactUi): ContactDomain {
        return with(model) {
            ContactDomain(
                name,
                number,
                date,
                id
            )
        }
    }
}