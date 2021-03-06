package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.openapitools.gardener.model.PlantTypeDto
import org.openapitools.gardener.model.Season
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
 * @param id 
 * @param plantType 
 * @param growingConfiguration 
 * @param season 
 * @param gardenerId 
 * @param createdAt 
 */
data class SpecimenDto(

    @get:NotNull 
    @JsonProperty("name") val name: kotlin.String,

    @get:NotNull 
    @JsonProperty("userId") val userId: java.util.UUID,

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("plantType") val plantType: PlantTypeDto? = null,

    @JsonProperty("growingConfiguration") val growingConfiguration: GrowingConfigurationDto? = null,

    @JsonProperty("season") val season: Season? = null,

    @JsonProperty("gardenerId") val gardenerId: java.util.UUID? = null,

    @JsonProperty("createdAt") val createdAt: java.time.OffsetDateTime? = null
) {

}

