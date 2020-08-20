package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.mapper.GenericMapper
import com.iulia.gardener.model.PlantFeature
import org.springframework.stereotype.Component

@Component
class FeaturesConfigurationMapper: GenericMapper<PlantFeature, FeaturesConfiguration> {

    override fun createEntity(dto: PlantFeature): FeaturesConfiguration {
        return FeaturesConfiguration(
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

    override fun updateEntity(dto: PlantFeature, entity: FeaturesConfiguration): FeaturesConfiguration {
        return FeaturesConfiguration(
                id = entity.id,
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

    override fun toDto(entity: FeaturesConfiguration): PlantFeature {
        return PlantFeature(
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
