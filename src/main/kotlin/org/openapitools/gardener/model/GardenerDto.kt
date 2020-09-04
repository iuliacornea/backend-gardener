package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.GardenerOrderDto
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
 * @param userId 
 * @param wifiNetwork 
 * @param wifiPassword 
 * @param order 
 * @param createdAt 
 * @param id 
 */
data class GardenerDto(

    @get:NotNull 
    @JsonProperty("name") val name: kotlin.String,

    @get:NotNull 
    @JsonProperty("userId") val userId: java.util.UUID,

    @get:NotNull 
    @JsonProperty("wifiNetwork") val wifiNetwork: kotlin.String,

    @get:NotNull 
    @JsonProperty("wifiPassword") val wifiPassword: kotlin.String,

    @get:NotNull 
    @JsonProperty("order") val order: GardenerOrderDto,

    @get:NotNull 
    @JsonProperty("createdAt") val createdAt: java.time.OffsetDateTime,

    @JsonProperty("id") val id: java.util.UUID? = null
) {

}

