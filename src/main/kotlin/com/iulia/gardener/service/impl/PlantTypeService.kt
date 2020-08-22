package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.PlantType
import com.iulia.gardener.mapper.impl.PlantTypeMapper
import com.iulia.gardener.model.PlantTypeDto
import com.iulia.gardener.repo.PlantTypeRepository
import com.iulia.gardener.service.GenericService
import org.springframework.stereotype.Component
import java.util.*

@Component
class PlantTypeService(
        override var mapper: PlantTypeMapper,
        override var repository: PlantTypeRepository,
        var featuresConfigurationService: FeaturesConfigurationService,
        var configurationService: GrowingConfigurationService)
    : GenericService<PlantType, PlantTypeDto, PlantTypeMapper, PlantTypeRepository>() {

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
}
