package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.GrowingConfigurations
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.springframework.stereotype.Component

@Component
class GrowingConfigurationsMapper: GenericMapper<GrowingConfigurationDto, GrowingConfigurations> {
    override fun toEntity(dto: GrowingConfigurationDto): GrowingConfigurations {
        return GrowingConfigurations (
                id = dto.id,
                airHumidity = dto.airHumidity,
                airTemperatureSummer = dto.airTemperatureSummer,
                airTemperatureWinter = dto.airTemperatureWinter,
                lightIntensity = dto.lightIntensity,
                soilHumiditySummer = dto.soilHumiditySummer,
                soilHumidityWinter = dto.soilHumidityWinter,
                soilType = dto.soilType,
                appUserId = dto.userId,
                name = dto.name,
                wateringIntervalDays = dto.wateringIntervalDays
        )
    }

    override fun toDto(entity: GrowingConfigurations): GrowingConfigurationDto {
        return GrowingConfigurationDto (
                id = entity.id,
                airHumidity = entity.airHumidity,
                airTemperatureSummer = entity.airTemperatureSummer,
                airTemperatureWinter = entity.airTemperatureWinter,
                lightIntensity = entity.lightIntensity,
                soilHumiditySummer = entity.soilHumiditySummer,
                soilHumidityWinter = entity.soilHumidityWinter,
                soilType = entity.soilType,
                userId = entity.appUserId,
                name = entity.name,
                wateringIntervalDays = entity.wateringIntervalDays
        )
    }


}
