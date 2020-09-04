package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.FeaturesConfigurationDto
import org.springframework.stereotype.Component

@Component
class FeaturesConfigurationMapper: GenericMapper<FeaturesConfigurationDto, FeaturesConfiguration> {

    override fun toEntity(dto: FeaturesConfigurationDto): FeaturesConfiguration {
        return FeaturesConfiguration(
                id = dto.id,
                stemType = dto.stemType,
                stemSpikes = dto.stemSpikes,
                leafDivisionOfBlade = dto.leafDivisionOfBlade,
                leafArrangementOnTheStem = dto.leafArrangementOnTheStem,
                leafSurface = dto.leafSurface,
                leafTexture = dto.leafTexture,
                leafVeinType = dto.leafVeinType,
                flowerExistance = dto.flowerExistance,
                flowerShape = dto.flowerShape,
                flowerPetals = dto.flowerPetals
        )
    }

    override fun toDto(entity: FeaturesConfiguration): FeaturesConfigurationDto {
        return FeaturesConfigurationDto(
                id = entity.id,
                stemType = entity.stemType,
                stemSpikes = entity.stemSpikes,
                leafDivisionOfBlade = entity.leafDivisionOfBlade,
                leafArrangementOnTheStem = entity.leafArrangementOnTheStem,
                leafSurface = entity.leafSurface,
                leafTexture = entity.leafTexture,
                leafVeinType = entity.leafVeinType,
                flowerExistance = entity.flowerExistance,
                flowerShape = entity.flowerShape,
                flowerPetals = entity.flowerPetals
        )
    }


}
