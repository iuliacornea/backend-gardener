package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param id 
 * @param userId 
 * @param gardenerId 
 * @param specimenId 
 * @param airTemperatureRaw 
 * @param airHumidityRaw 
 * @param soilMoistureRaw 
 * @param lightIntensityRaw 
 * @param airTemperatureCelsius 
 * @param airHumidityPercentage 
 * @param soilMoisturePercentage 
 * @param lightIntensityLux 
 * @param receivedAt 
 */
data class GreenhouseStatsDto(

    @get:NotNull 
    @JsonProperty("id") val id: java.util.UUID,

    @get:NotNull 
    @JsonProperty("userId") val userId: java.util.UUID,

    @get:NotNull 
    @JsonProperty("gardenerId") val gardenerId: java.util.UUID,

    @JsonProperty("specimenId") val specimenId: java.util.UUID? = null,

    @JsonProperty("airTemperatureRaw") val airTemperatureRaw: kotlin.Int? = null,

    @JsonProperty("airHumidityRaw") val airHumidityRaw: kotlin.Int? = null,

    @JsonProperty("soilMoistureRaw") val soilMoistureRaw: kotlin.Int? = null,

    @JsonProperty("lightIntensityRaw") val lightIntensityRaw: kotlin.Int? = null,

    @JsonProperty("airTemperatureCelsius") val airTemperatureCelsius: kotlin.Int? = null,

    @JsonProperty("airHumidityPercentage") val airHumidityPercentage: kotlin.Int? = null,

    @JsonProperty("soilMoisturePercentage") val soilMoisturePercentage: kotlin.Int? = null,

    @JsonProperty("lightIntensityLux") val lightIntensityLux: kotlin.Int? = null,

    @JsonProperty("receivedAt") val receivedAt: java.time.OffsetDateTime? = null
) {

}

