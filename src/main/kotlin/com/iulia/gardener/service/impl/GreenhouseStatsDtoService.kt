package com.iulia.gardener.service.impl

import com.iulia.gardener.mapper.impl.GreenhouseStatsMapper
import com.iulia.gardener.repo.GreenhouseStatsRepository
import org.openapitools.gardener.model.GreenhouseMessageDto
import org.openapitools.gardener.model.GreenhouseStatsDto
import org.openapitools.gardener.model.UserDto
import org.openapitools.gardener.model.UserRole
import org.springframework.stereotype.Component
import java.util.*

@Component
class GreenhouseStatsDtoService(
        private var mapper: GreenhouseStatsMapper,
        private var repository: GreenhouseStatsRepository,
        private var gardenerDtoService: GardenerDtoService,
        private var specimenDtoService: SpecimenDtoService) {

    fun saveMessage(greenhouseMessageDto: GreenhouseMessageDto): GreenhouseStatsDto {
        val entity = repository.saveAndFlush(mapper.toEntityFromMessage(greenhouseMessageDto))
        return mapper.toDto(entity)
    }

    fun getStats(requester: UserDto, gardenerId: UUID?, specimenId: UUID?): List<GreenhouseStatsDto> {
        if (requester.role == UserRole.ADMIN) {
            return getByGardenerIdAndSpecimenId(gardenerId, specimenId)
        } else {
            var gardenerOwnerId: UUID? = null
            if (gardenerId != null && gardenerDtoService.getGardener(gardenerId).userId == requester.id) {
                gardenerOwnerId = gardenerId
            }
            var specimenOwnerId: UUID? = null
            if (specimenId != null && specimenDtoService.getSpecimen(specimenId).userId == requester.id) {
                specimenOwnerId = specimenId
            }
            if (gardenerOwnerId != null || specimenOwnerId != null) {
                return getByGardenerIdAndSpecimenId(gardenerOwnerId, specimenOwnerId)
            } else {
                return repository.findAllByUserId(requester.id!!).map { mapper.toDto(it) }
            }
        }
    }

    fun getByGardenerIdAndSpecimenId(gardenerId: UUID?, specimenId: UUID?): List<GreenhouseStatsDto> {
        return if (gardenerId == null && specimenId == null) {
            repository.findAll().map { mapper.toDto(it) }
        } else if (gardenerId != null && specimenId == null) {
            repository.findAllByGardenerId(gardenerId).map { mapper.toDto(it) }
        } else if (gardenerId == null && specimenId != null) {
            repository.findAllBySpecimenId(specimenId).map { mapper.toDto(it) }
        } else {
            repository.findAllByGardenerIdAndSpecimenId(gardenerId!!, specimenId!!).map { mapper.toDto(it) }
        }
    }
}
