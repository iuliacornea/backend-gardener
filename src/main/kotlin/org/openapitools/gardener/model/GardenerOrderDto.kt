package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.OrderStatus
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param gardenerName 
 * @param userId 
 * @param wifiNetwork 
 * @param wifiPassword 
 * @param id 
 * @param createdAt 
 * @param status 
 * @param lastUpdate 
 */
data class GardenerOrderDto(

    @get:NotNull 
    @JsonProperty("gardenerName") val gardenerName: kotlin.String,

    @get:NotNull 
    @JsonProperty("userId") val userId: java.util.UUID,

    @get:NotNull 
    @JsonProperty("wifiNetwork") val wifiNetwork: kotlin.String,

    @get:NotNull 
    @JsonProperty("wifiPassword") val wifiPassword: kotlin.String,

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("createdAt") val createdAt: java.time.OffsetDateTime? = null,

    @JsonProperty("status") val status: OrderStatus? = null,

    @JsonProperty("lastUpdate") val lastUpdate: java.time.OffsetDateTime? = null
) {

}

