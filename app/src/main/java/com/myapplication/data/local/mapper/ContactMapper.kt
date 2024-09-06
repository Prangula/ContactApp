package com.myapplication.data.local.mapper

import com.myapplication.data.local.entity.ContactEntity
import com.myapplication.domain.mapper.EntityMapper
import com.myapplication.domain.model.Contact

class ContactMapper : EntityMapper<ContactEntity, Contact> {

    override fun mapFromEntity(entity: ContactEntity): Contact {
        with(entity) {
            return Contact(
                name,
                number,
                date,
                id
            )
        }
    }

    override fun mapToEntity(domainModel: Contact): ContactEntity {
        with(domainModel) {
            return ContactEntity(
                name,
                number,
                date,
                id
            )
        }
    }
}