package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.entity.GrowingConfiguration
import com.iulia.gardener.entity.PlantType
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.FeaturesConfigurationDto
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.openapitools.gardener.model.PlantTypeDto
import org.springframework.stereotype.Component

@Component
class PlantTypeMapper(
        var featuresConfigurationMapper: FeaturesConfigurationMapper,
        var growingConfigurationsMapper: GrowingConfigurationsMapper
) : GenericMapper<PlantTypeDto, PlantType> {

    override fun toEntity(dto: PlantTypeDto): PlantType {
        var featuresConfig: FeaturesConfiguration? = null
        if (dto.featuresConfiguration != null) {
            featuresConfig = featuresConfigurationMapper.toEntity(dto.featuresConfiguration)
        }
        var growingConfig: GrowingConfiguration? = null
        if(dto.growingConfiguration != null) {
            growingConfig = growingConfigurationsMapper.toEntity(dto.growingConfiguration)
        }

        return PlantType(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                featuresConfiguration = featuresConfig,
                growingConfiguration = growingConfig,
                image = dto.image,
                appUserId = dto.userId
        )
    }

    override fun toDto(entity: PlantType): PlantTypeDto {
        var featuresConfig: FeaturesConfigurationDto? = null
        if (entity.featuresConfiguration != null) {
            featuresConfig = featuresConfigurationMapper.toDto(entity.featuresConfiguration!!)
        }
        var growingConfig: GrowingConfigurationDto? = null
        if (entity.growingConfiguration != null) {
            growingConfig = growingConfigurationsMapper.toDto(entity.growingConfiguration!!)
        }

        return PlantTypeDto(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                featuresConfiguration = featuresConfig,
                growingConfiguration = growingConfig,
                image = entity.image,
                userId = entity.appUserId
        )
    }

}
