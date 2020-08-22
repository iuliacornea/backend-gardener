package com.iulia.gardener.service

import com.iulia.gardener.entity.UuidEntity
import com.iulia.gardener.mapper.GenericMapper
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import java.util.*

abstract class GenericDtoService <Entity: UuidEntity, Dto, Mapper: GenericMapper<Dto, Entity>, Repository: JpaRepository<Entity, UUID>> {

    abstract var mapper: Mapper
    abstract var repository: Repository

    open fun save(dto: Dto): Dto {
        var toBeSaved = mapper.toEntity(dto)
        var saved = repository.saveAndFlush(toBeSaved)
        return mapper.toDto(saved)
    }

    fun getAll(): List<Dto> {
        var entities = repository.findAll()
        return entities.map { mapper.toDto(it) }
    }

    fun getOne(uuid: UUID): Dto? {
        var entity = repository.findByIdOrNull(uuid)
        if (entity != null) {
            return mapper.toDto(entity)
        }
        return null
    }

    fun delete(uuid: UUID) {
        repository.deleteById(uuid)
    }

    abstract fun getDtoId(dto: Dto): UUID?
}
