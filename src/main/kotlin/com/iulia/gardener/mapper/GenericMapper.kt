package com.iulia.gardener.mapper

interface GenericMapper<Dto, Entity> {

    fun toEntity(dto: Dto) : Entity

    fun toDto(entity: Entity): Dto
}
