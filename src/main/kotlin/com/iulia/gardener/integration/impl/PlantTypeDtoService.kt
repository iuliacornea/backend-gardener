package com.iulia.gardener.integration.impl

import com.iulia.gardener.entity.PlantType
import com.iulia.gardener.mapper.impl.PlantTypeMapper
import org.openapitools.gardener.model.PlantTypeDto
import com.iulia.gardener.repo.PlantTypeRepository
import com.iulia.gardener.integration.GenericDtoService
import org.springframework.stereotype.Component
import java.util.*

@Component
class PlantTypeDtoService(
        override var mapper: PlantTypeMapper,
        override var repository: PlantTypeRepository,
        var featuresConfigurationService: FeaturesConfigurationDtoService,
        var configurationService: GrowingConfigurationDtoService)
    : GenericDtoService<PlantType, PlantTypeDto, PlantTypeMapper, PlantTypeRepository>() {

    override fun save(dto: PlantTypeDto): PlantTypeDto {
        var features = featuresConfigurationService.save(dto.featuresConfiguration)
        var growingConfiguration = configurationService.save(dto.growingConfiguration)

        var entity = mapper.toEntity(dto)
        entity.featuresConfiguration.id = features.id
        entity.growingConfigurations.id = growingConfiguration.id

        repository.saveAndFlush(entity)
        return mapper.toDto(entity)
    }

    override fun getDtoId(dto: PlantTypeDto): UUID? {
        return dto.id
    }

    fun getAllByUserUuid(userUUID: UUID): List<PlantTypeDto>? {
        return repository.getAllByUserUuid(userUUID)?.map { mapper.toDto(it) }
    }

    fun getGlobalPlantTypes(): List<PlantTypeDto> {
        return repository.getAllByUserUuid(null)!!.map { mapper.toDto(it) }
    }
}
