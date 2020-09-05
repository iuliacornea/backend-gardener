package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.GreenhouseStats
import com.iulia.gardener.repo.SpecimenRepository
import org.openapitools.gardener.model.GreenhouseMessageDto
import org.openapitools.gardener.model.GreenhouseStatsDto
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId

@Component
class GreenhouseStatsMapper (private var specimenRepository: SpecimenRepository){

    fun toEntityFromMessage(greenhouseMessage: GreenhouseMessageDto): GreenhouseStats {
        return GreenhouseStats(
                userId = greenhouseMessage.userId,
                gardenerId = greenhouseMessage.gardenerId,
                specimenId = specimenRepository.findByGardenerId(greenhouseMessage.gardenerId)?.id,
                receivedAt = Timestamp.from(Instant.now()),
                airHumidityRaw = greenhouseMessage.airHumidity,
                airHumidityPercentage = greenhouseMessage.airHumidity,
                airTemperatureRaw = greenhouseMessage.airTemperature,
                airTemperatureCelsius = greenhouseMessage.airTemperature,
                lightIntensityRaw = greenhouseMessage.lightIntensity,
                lightIntensityLux = getLuxFromRawLightIntensity(greenhouseMessage.lightIntensity),
                soilMoistureRaw = greenhouseMessage.soilMoisture,
                soilMoisturePercentage = getPercentageFromRawSoilMoisture(greenhouseMessage.soilMoisture)
        )
    }

    fun toDto(entity: GreenhouseStats): GreenhouseStatsDto {
        return GreenhouseStatsDto(
                id = entity.id!!,
                gardenerId = entity.gardenerId,
                specimenId = entity.specimenId,
                receivedAt = OffsetDateTime.ofInstant(entity.receivedAt.toInstant(), ZoneId.systemDefault()) ,
                soilMoistureRaw = entity.soilMoistureRaw,
                soilMoisturePercentage = entity.soilMoisturePercentage,
                lightIntensityLux = entity.lightIntensityLux,
                lightIntensityRaw = entity.lightIntensityRaw,
                airTemperatureCelsius = entity.airTemperatureCelsius,
                airTemperatureRaw = entity.airTemperatureRaw,
                airHumidityRaw = entity.airHumidityRaw,
                airHumidityPercentage = entity.airHumidityPercentage,
                userId = entity.userId
        )
    }


    /**
     * immersion into water = registered soil moisture of aprox 470
     * immersison into air or very dry soil = registered soil moisture of 1022
     * raw value...................percentage
     *    1020......................0%
     *       x......................y%
     *     470....................100%
     */
    private fun getPercentageFromRawSoilMoisture(rawValue: Int): Int {
        return getTranslatedValue(rawValue, MIN_SOIL_MOISTURE_RAW, MAX_SOIL_MOISTURE_RAW, MIN_SOIL_MOISTURE_PERCENTAGE, MAX_SOIL_MOISTURE_PERCENTAGE)
    }

    private fun getLuxFromRawLightIntensity(rawValue: Int): Int {
        return getTranslatedValue(rawValue, MIN_PHOTORESISTOR_VALUE_RAW, MAX_PHOTORESISTOR_VALUE_RAW, MIN_LIGHT_LUX, MAX_LIGHT_LUX)
    }

    private fun getTranslatedValue(oldValue: Int, oldMin: Int, oldMax: Int, newMin: Int, newMax: Int): Int {
        if (oldValue < oldMin) {
            return newMin
        }
        if (oldValue > oldMax) {
            return newMax
        }
        var oldInterval = oldMax - oldMin
        var newInterval = newMax - newMin
        return oldValue / oldInterval * newInterval
    }

    companion object Constants {
        private var MIN_SOIL_MOISTURE_RAW = 470
        private var MAX_SOIL_MOISTURE_RAW = 1020
        private var MIN_SOIL_MOISTURE_PERCENTAGE = 0
        private var MAX_SOIL_MOISTURE_PERCENTAGE = 100
        private var MIN_PHOTORESISTOR_VALUE_RAW = 13
        private var MAX_PHOTORESISTOR_VALUE_RAW = 230
        private var MIN_LIGHT_LUX = 200
        private var MAX_LIGHT_LUX = 50000
    }
}
