package com.myapplication.domain.domainMapper

import com.myapplication.domain.model.ContactDomain
import com.myapplication.presentation.model.ContactUi
import com.myapplication.utils.UiMapper

class ContactUiMapper : UiMapper<ContactDomain, ContactUi> {
    override fun invoke(model: ContactDomain): ContactUi {
        return with(model) {
            ContactUi(
                name,
                number,
                date,
                id
            )
        }
    }

    override fun reverse(model: ContactUi): ContactDomain {
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