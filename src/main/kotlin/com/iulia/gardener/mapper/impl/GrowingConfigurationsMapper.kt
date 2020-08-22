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
                lightIntensitySummer = dto.lightIntensitySummer,
                lightIntensityWinter = dto.lightIntensityWinter,
                soilHumiditySummer = dto.soilHumiditySummer,
                soilHumidityWinter = dto.soilHumidityWinter,
                soilQuantity = dto.soilQuantity,
                soilType = dto.soilType

        )
    }

    override fun toDto(entity: GrowingConfigurations): GrowingConfigurationDto {
        return GrowingConfigurationDto (
                id = entity.id,
                airHumidity = entity.airHumidity,
                airTemperatureSummer = entity.airTemperatureSummer,
                airTemperatureWinter = entity.airTemperatureWinter,
                lightIntensitySummer = entity.lightIntensitySummer,
                lightIntensityWinter = entity.lightIntensityWinter,
                soilHumiditySummer = entity.soilHumiditySummer,
                soilHumidityWinter = entity.soilHumidityWinter,
                soilQuantity = entity.soilQuantity,
                soilType = entity.soilType

        )
    }


}
