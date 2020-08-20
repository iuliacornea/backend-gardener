package com.iulia.gardener.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *
 * @param id
 * @param name
 * @param featuresConfiguration
 * @param soilType
 */
data class PlantTypeDto(

        @JsonProperty("id") val id: java.util.UUID? = null,

        @JsonProperty("name") val name: String,

        @JsonProperty("description") val description: String? = null,

        @JsonProperty("image") val image: ByteArray? = null,

        @JsonProperty("featuresConfiguration") val featuresConfiguration: FeaturesConfigurationDto,

        @JsonProperty("growingConfiguration") val growingConfiguration: GrowingConfigurationDto
) {

}

