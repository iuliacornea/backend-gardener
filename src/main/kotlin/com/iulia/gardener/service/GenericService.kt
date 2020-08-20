package com.iulia.gardener.service

import com.iulia.gardener.entity.UuidEntity
import com.iulia.gardener.mapper.GenericMapper
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

abstract class GenericService <Entity: UuidEntity, Dto, Mapper: GenericMapper<Dto, Entity>, Repository: JpaRepository<Entity, UUID>> {

    abstract var mapper: Mapper
    abstract var repository: Repository

    fun save(dto: Dto): Dto {
        return if(getDtoId(dto) == null) {
            create(dto)
        } else {
            update(dto)
        }
    }

    private fun create(dto: Dto): Dto  {
        var toBeSaved = mapper.createEntity(dto)
        var created = repository.saveAndFlush(toBeSaved)
        return mapper.toDto(created)
    }

    private fun update(dto: Dto): Dto  {
        var existing = repository.getOne(getDtoId(dto)!!)
        var tobeUpdated = mapper.updateEntity(dto, existing)
        var updated = repository.saveAndFlush(tobeUpdated)
        return mapper.toDto(updated)
    }

    abstract fun getDtoId(dto: Dto): UUID?
}
