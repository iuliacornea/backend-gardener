package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.GrowingConfiguration
import com.iulia.gardener.entity.PlantType
import com.iulia.gardener.entity.Specimen
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.openapitools.gardener.model.PlantTypeDto
import org.openapitools.gardener.model.SpecimenDto
import org.springframework.stereotype.Component
import java.sql.Time
import java.sql.Timestamp
import java.time.Instant

@Component
class SpecimenMapper(
        var growingConfigurationsMapper: GrowingConfigurationsMapper,
        var plantTypeMapper: PlantTypeMapper
): GenericMapper<SpecimenDto, Specimen> {

    override fun toEntity(dto: SpecimenDto): Specimen {
        var growingConfiguration: GrowingConfiguration? = null
        if (dto.growingConfiguration != null) {
            growingConfiguration = growingConfigurationsMapper.toEntity(dto.growingConfiguration)
        }
        var plantType: PlantType? = null
        if (dto.plantType != null) {
            plantType = plantTypeMapper.toEntity(dto.plantType)
        }
        var createdAt: Timestamp? = Timestamp.from(Instant.now())
        if(dto.createdAt != null)
        {
            createdAt = Timestamp.from(dto.createdAt.toInstant())
        }
        return Specimen(
                id = dto.id,
                name = dto.name,
                appUserId =  dto.userId,
                growingConfiguration = growingConfiguration,
                plantType = plantType,
                season = dto.season,
                createdAt = createdAt,
                gardenerId = dto.gardenerId
        )
    }

    override fun toDto(entity: Specimen): SpecimenDto {
        var growingConfigurations: GrowingConfigurationDto? = null
        var plantType: PlantTypeDto? = null
        if (entity.growingConfiguration != null) {
            growingConfigurations = growingConfigurationsMapper.toDto(entity.growingConfiguration!!)
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
