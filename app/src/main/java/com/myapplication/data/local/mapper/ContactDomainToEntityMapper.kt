package com.myapplication.data.local.mapper

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.model.ContactDomain
import com.myapplication.utils.UiMapper

class ContactDomainToEntityMapper : UiMapper<ContactDomain, ContactEntity> {
    override fun mapModel(model: ContactDomain): ContactEntity {
        return with(model) {
            ContactEntity(
                name,
                number,
                date,
                id
            )
        }
    }
}