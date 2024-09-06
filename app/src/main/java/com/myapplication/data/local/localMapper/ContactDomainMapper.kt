package com.myapplication.data.local.localMapper

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.model.ContactDomain
import com.myapplication.utils.UiMapper

class ContactDomainMapper : UiMapper<ContactEntity, ContactDomain> {

    override fun invoke(model: ContactEntity): ContactDomain {
        with(model) {
            return ContactDomain(
                name,
                number,
                date,
                id
            )
        }
    }

    override fun reverse(model: ContactDomain): ContactEntity {
        with(model){
            return ContactEntity(
                name,
                number,
                date,
                id
            )
        }
    }
}