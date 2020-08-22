package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.FeaturesConfigurationDto
import org.openapitools.gardener.model.GrowingConfigurationDto
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
 * @param featuresConfiguration 
 * @param growingConfiguration 
 * @param id 
 * @param description 
 * @param image 
 */
data class PlantTypeDto(

    @get:NotNull 
    @JsonProperty("name") val name: kotlin.String,

    @get:NotNull 
    @JsonProperty("featuresConfiguration") val featuresConfiguration: FeaturesConfigurationDto,

    @get:NotNull 
    @JsonProperty("growingConfiguration") val growingConfiguration: GrowingConfigurationDto,

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("description") val description: kotlin.String? = null,

    @JsonProperty("image") val image: kotlin.String? = null
) {

}

