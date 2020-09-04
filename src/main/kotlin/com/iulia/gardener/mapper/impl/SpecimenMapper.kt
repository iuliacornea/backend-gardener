package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.GrowingConfigurations
import com.iulia.gardener.entity.PlantType
import com.iulia.gardener.entity.Specimen
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.openapitools.gardener.model.PlantTypeDto
import org.openapitools.gardener.model.SpecimenDto
import org.springframework.stereotype.Component
import java.sql.Timestamp

@Component
class SpecimenMapper(
        var growingConfigurationsMapper: GrowingConfigurationsMapper,
        var plantTypeMapper: PlantTypeMapper
): GenericMapper<SpecimenDto, Specimen> {

    override fun toEntity(dto: SpecimenDto): Specimen {
        var growingConfigurations: GrowingConfigurations? = null
        var plantType: PlantType? = null
        if (dto.growingConfiguration != null) {
            growingConfigurations = growingConfigurationsMapper.toEntity(dto.growingConfiguration)
        }
        if (dto.plantType != null) {
            plantType = plantTypeMapper.toEntity(dto.plantType)
        }
        return Specimen(
                id = dto.id,
                name = dto.name,
                appUserId =  dto.userId,
                growingConfigurations = growingConfigurations,
                plantType = plantType,
                season = dto.season,
                createdAt = Timestamp.from(dto.createdAt?.toInstant()),
                gardenerEntity = null
        )
    }

    override fun toDto(entity: Specimen): SpecimenDto {
        var growingConfigurations: GrowingConfigurationDto? = null
        var plantType: PlantTypeDto? = null
        if (entity.growingConfigurations != null) {
            growingConfigurations = growingConfigurationsMapper.toDto(entity.growingConfigurations!!)
        }
        if (entity.plantType != null) {
            plantType = plantTypeMapper.toDto(entity.plantType!!)
        }
        return SpecimenDto(
                id = entity.id,
                name = entity.name,
                growingConfiguration = growingConfigurations,
                plantType = plantType,
                season = entity.season,
                userId = entity.appUserId
        )
    }
}
