package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.entity.GrowingConfigurations
import com.iulia.gardener.entity.PlantType
import com.iulia.gardener.mapper.GenericMapper
import com.iulia.gardener.model.FeaturesConfigurationDto
import com.iulia.gardener.model.GrowingConfigurationDto
import com.iulia.gardener.model.PlantTypeDto
import org.springframework.stereotype.Component

@Component
class PlantTypeMapper(
    var featuresConfigurationMapper: FeaturesConfigurationMapper,
    var growingConfigurationsMapper: GrowingConfigurationsMapper
): GenericMapper<PlantTypeDto, PlantType> {

    override fun toEntity(dto: PlantTypeDto): PlantType {
        var featuresConfig: FeaturesConfiguration = featuresConfigurationMapper.toEntity(dto.featuresConfiguration)
        var growingConfig: GrowingConfigurations = growingConfigurationsMapper.toEntity(dto.growingConfiguration)

        return PlantType(
                id = dto.id,
                name = dto.name,
                description = dto.description,
                featuresConfiguration = featuresConfig,
                growingConfigurations = growingConfig,
                image = dto.image
        )
    }

    override fun toDto(entity: PlantType): PlantTypeDto {
        var featuresConfig: FeaturesConfigurationDto = featuresConfigurationMapper.toDto(entity.featuresConfiguration)
        var growingConfig: GrowingConfigurationDto = growingConfigurationsMapper.toDto(entity.growingConfigurations)

        return PlantTypeDto(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                featuresConfiguration = featuresConfig,
                growingConfiguration = growingConfig,
                image = entity.image
        )
    }

}
