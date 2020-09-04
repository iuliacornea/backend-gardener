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
 * @param gardenerId 
 * @param airTemperature 
 * @param airHumidity 
 * @param soilMoisture 
 * @param lightIntensity 
 */
data class GreenhouseMessageDto(

    @get:NotNull 
    @JsonProperty("gardenerId") val gardenerId: java.util.UUID,

    @get:NotNull 
    @JsonProperty("airTemperature") val airTemperature: kotlin.Int,

    @get:NotNull 
    @JsonProperty("airHumidity") val airHumidity: kotlin.Int,

    @get:NotNull 
    @JsonProperty("soilMoisture") val soilMoisture: kotlin.Int,

    @get:NotNull 
    @JsonProperty("lightIntensity") val lightIntensity: kotlin.Int
) {

}

