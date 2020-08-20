package com.iulia.gardener.mapper

interface GenericMapper<Dto, Entity> {

    fun createEntity(dto: Dto) : Entity

    fun updateEntity(dto: Dto, entity: Entity): Entity

    fun toDto(entity: Entity): Dto
}
