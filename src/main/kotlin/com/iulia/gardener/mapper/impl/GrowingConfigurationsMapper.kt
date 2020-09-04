package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.GrowingConfiguration
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.springframework.stereotype.Component

@Component
class GrowingConfigurationsMapper: GenericMapper<GrowingConfigurationDto, GrowingConfiguration> {
    override fun toEntity(dto: GrowingConfigurationDto): GrowingConfiguration {
        return GrowingConfiguration (
                id = dto.id,
                airHumidityMin = dto.airHumidityMin,
                airHumidityMax = dto.airHumidityMax,
                airTemperatureSummerMin = dto.airTemperatureSummerMin,
                airTemperatureSummerMax = dto.airTemperatureSummerMax,
                airTemperatureWinterMin = dto.airTemperatureWinterMin,
                airTemperatureWinterMax = dto.airTemperatureWinterMax,
                lightIntensityMin = dto.lightIntensityMin,
                lightIntensityMax = dto.lightIntensityMax,
                soilMoistureSummerMin = dto.soilMoistureSummerMin,
                soilMoistureSummerMax = dto.soilMoistureSummerMax,
                soilMoistureWinterMin = dto.soilMoistureWinterMin,
                soilMoistureWinterMax = dto.soilMoistureWinterMax,
                appUserId = dto.userId,
                name = dto.name,
                wateringIntervalDays = dto.wateringIntervalDays
        )
    }

    override fun toDto(entity: GrowingConfiguration): GrowingConfigurationDto {
        return GrowingConfigurationDto (
                id = entity.id,
                airHumidityMin = entity.airHumidityMin,
                airHumidityMax = entity.airHumidityMax,
                airTemperatureSummerMin = entity.airTemperatureSummerMin,
                airTemperatureSummerMax = entity.airTemperatureSummerMax,
                airTemperatureWinterMin = entity.airTemperatureWinterMin,
                airTemperatureWinterMax = entity.airTemperatureWinterMax,
                lightIntensityMin = entity.lightIntensityMin,
                lightIntensityMax = entity.lightIntensityMax,
                soilMoistureSummerMin = entity.soilMoistureSummerMin,
                soilMoistureSummerMax = entity.soilMoistureSummerMax,
                soilMoistureWinterMin = entity.soilMoistureWinterMin,
                soilMoistureWinterMax = entity.soilMoistureWinterMax,
                userId = entity.appUserId,
                name = entity.name,
                wateringIntervalDays = entity.wateringIntervalDays
        )
    }


}
