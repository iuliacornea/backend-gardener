package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.SoilType
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param name 
 * @param id 
 * @param airHumidity 
 * @param airTemperatureSummer 
 * @param airTemperatureWinter 
 * @param lightIntensity 
 * @param soilHumiditySummer 
 * @param soilHumidityWinter 
 * @param soilType 
 * @param userId 
 * @param wateringIntervalDays 
 */
data class GrowingConfigurationDto(

    @get:NotNull 
    @JsonProperty("name") val name: kotlin.String,

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("airHumidity") val airHumidity: kotlin.Int? = null,

    @JsonProperty("airTemperatureSummer") val airTemperatureSummer: kotlin.Int? = null,

    @JsonProperty("airTemperatureWinter") val airTemperatureWinter: kotlin.Int? = null,

    @JsonProperty("lightIntensity") val lightIntensity: kotlin.Int? = null,

    @JsonProperty("soilHumiditySummer") val soilHumiditySummer: kotlin.Int? = null,

    @JsonProperty("soilHumidityWinter") val soilHumidityWinter: kotlin.Int? = null,

    @JsonProperty("soilType") val soilType: SoilType? = null,

    @JsonProperty("userId") val userId: java.util.UUID? = null,

    @JsonProperty("wateringIntervalDays") val wateringIntervalDays: kotlin.Int? = null
) {

}

