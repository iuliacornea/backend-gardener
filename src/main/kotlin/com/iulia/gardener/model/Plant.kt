package com.iulia.gardener.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *
 * @param id
 * @param name
 * @param features
 * @param soilType
 */
data class Plant(

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("name") val name: String? = null,

    @JsonProperty("description") val description: String? = null,

    @JsonProperty("image") val image: ByteArray? = null,

    @JsonProperty("features") val features: PlantFeature? = null,

    @JsonProperty("soilType") val soilType: SoilType? = null
) {

}

