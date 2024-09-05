package com.myapplication.data.mapper

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

    fun fromEntityList(initial: List<ContactEntity>): List<Contact> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<Contact>): List<ContactEntity> {
        return initial.map { mapToEntity(it) }
    }
}