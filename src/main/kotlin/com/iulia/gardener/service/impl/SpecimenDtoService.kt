package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.Specimen
import com.iulia.gardener.mapper.impl.SpecimenMapper
import com.iulia.gardener.repo.SpecimenRepository
import org.openapitools.gardener.model.GardenerDto
import org.openapitools.gardener.model.SpecimenDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class SpecimenDtoService(var mapper: SpecimenMapper, var repository: SpecimenRepository) {

    fun getSpecimens(userId: UUID): List<SpecimenDto> {
        var list = mutableListOf<Specimen>()
        list.addAll(repository.getAllByAppUserId(userId) as Iterable<Specimen>)
        return list.map { mapper.toDto(it) }
    }

    fun getSpecimen(id: UUID): SpecimenDto {
        return mapper.toDto(repository.getOne(id))
    }

    fun deleteSpecimen(id: UUID) {
        repository.deleteById(id)
    }

    fun saveSpecimen(specimenDto: SpecimenDto): SpecimenDto {
        var saved = repository.save(mapper.toEntity(specimenDto))
        return mapper.toDto(saved)
    }

    fun getAllSpecimentWithGardenerIn(gardeners: List<GardenerDto>): List<SpecimenDto> {
        val gardenerIds = mutableListOf<UUID>()
        gardeners.forEach { if (it.id != null) gardenerIds.add(it.id) }
        return repository.findAllByGardenerIdIn(gardenerIds).map { mapper.toDto(it) }
    }

}
