package com.myapplication.presentation.mapper

import com.myapplication.domain.model.ContactDomain
import com.myapplication.presentation.model.ContactUi
import com.myapplication.utils.UiMapper

class ContactDomainToUiMapper : UiMapper<ContactDomain, ContactUi> {
    override fun mapModel(model: ContactDomain): ContactUi {
        return with(model) {
            ContactUi(
                name,
                number,
                date,
                id
            )
        }
    }
}