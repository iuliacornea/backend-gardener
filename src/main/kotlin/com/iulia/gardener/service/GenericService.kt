package com.iulia.gardener.service

import com.iulia.gardener.entity.UuidEntity
import com.iulia.gardener.mapper.GenericMapper
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

abstract class GenericService <Entity: UuidEntity, Dto, Mapper: GenericMapper<Dto, Entity>, Repository: JpaRepository<Entity, UUID>> {

    abstract var mapper: Mapper
    abstract var repository: Repository

    fun save(dto: Dto): Dto {
        var toBeSaved = mapper.toEntity(dto)
        var saved = repository.saveAndFlush(toBeSaved)
        return mapper.toDto(saved)
    }

    abstract fun getDtoId(dto: Dto): UUID?
}
