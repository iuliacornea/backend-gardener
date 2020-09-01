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
 * @param user 
 * @param airTemperature 
 * @param airHumidity 
 * @param soilMoisture 
 * @param photoresistance 
 */
data class GreenhouseStatsDto(

    @JsonProperty("user") val user: kotlin.String? = null,

    @JsonProperty("airTemperature") val airTemperature: java.math.BigDecimal? = null,

    @JsonProperty("airHumidity") val airHumidity: java.math.BigDecimal? = null,

    @JsonProperty("soilMoisture") val soilMoisture: java.math.BigDecimal? = null,

    @JsonProperty("photoresistance") val photoresistance: java.math.BigDecimal? = null
) {

}

