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
 * @param name 
 * @param id 
 * @param airHumidityMin 
 * @param airHumidityMax 
 * @param airTemperatureSummerMin 
 * @param airTemperatureSummerMax 
 * @param airTemperatureWinterMin 
 * @param airTemperatureWinterMax 
 * @param lightIntensityMin 
 * @param lightIntensityMax 
 * @param soilMoistureSummerMin 
 * @param soilMoistureSummerMax 
 * @param soilMoistureWinterMin 
 * @param soilMoistureWinterMax 
 * @param userId 
 * @param wateringIntervalDays 
 */
data class GrowingConfigurationDto(

    @get:NotNull 
    @JsonProperty("name") val name: kotlin.String,

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("airHumidityMin") val airHumidityMin: kotlin.Int? = null,

    @JsonProperty("airHumidityMax") val airHumidityMax: kotlin.Int? = null,

    @JsonProperty("airTemperatureSummerMin") val airTemperatureSummerMin: kotlin.Int? = null,

    @JsonProperty("airTemperatureSummerMax") val airTemperatureSummerMax: kotlin.Int? = null,

    @JsonProperty("airTemperatureWinterMin") val airTemperatureWinterMin: kotlin.Int? = null,

    @JsonProperty("airTemperatureWinterMax") val airTemperatureWinterMax: kotlin.Int? = null,

    @JsonProperty("lightIntensityMin") val lightIntensityMin: kotlin.Int? = null,

    @JsonProperty("lightIntensityMax") val lightIntensityMax: kotlin.Int? = null,

    @JsonProperty("soilMoistureSummerMin") val soilMoistureSummerMin: kotlin.Int? = null,

    @JsonProperty("soilMoistureSummerMax") val soilMoistureSummerMax: kotlin.Int? = null,

    @JsonProperty("soilMoistureWinterMin") val soilMoistureWinterMin: kotlin.Int? = null,

    @JsonProperty("soilMoistureWinterMax") val soilMoistureWinterMax: kotlin.Int? = null,

    @JsonProperty("userId") val userId: java.util.UUID? = null,

    @JsonProperty("wateringIntervalDays") val wateringIntervalDays: kotlin.Int? = null
) {

}

