package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.PlantFeature
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
 * @param id 
 * @param name 
 * @param features 
 * @param soilType 
 */
data class Plant(

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("name") val name: kotlin.String? = null,

    @JsonProperty("features") val features: PlantFeature? = null,

    @JsonProperty("soilType") val soilType: SoilType? = null
) {

}

