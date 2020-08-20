package com.iulia.gardener.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class SpecimenDto(

        @JsonProperty("id") val id: java.util.UUID? = null,

        @JsonProperty("name") val name: String,

        @JsonProperty("appUserId") val appUserId: UUID,

        @JsonProperty("plantType") val plantType: PlantTypeDto?,

        @JsonProperty("growingConfiguration") val growingConfiguration: GrowingConfigurationDto?,

        @JsonProperty("season") val season: Season
) {
}
