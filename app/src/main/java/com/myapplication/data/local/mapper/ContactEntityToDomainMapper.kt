package com.myapplication.data.local.mapper

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.model.ContactDomain
import com.myapplication.utils.UiMapper

class ContactEntityToDomainMapper : UiMapper<ContactEntity, ContactDomain> {
    override fun mapModel(model: ContactEntity): ContactDomain {
        with(model) {
            return ContactDomain(
                name,
                number,
                date,
                id
            )
        }
    }
}