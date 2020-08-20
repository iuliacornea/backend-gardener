package com.iulia.gardener.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *
 * @param soilType
 * @param soilQuantity
 * @param soilHumiditySummer
 * @param soilHumidityWinter
 * @param airHumidity
 * @param airTemperatureSummer
 * @param airTemperatureWinter
 * @param lightIntensitySummer
 * @param lightIntensityWinter
 */
data class GrowingConfigurationDto(

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("soilType") val soilType: SoilType? = null,

    @JsonProperty("soilQuantity") val soilQuantity: Int? = null,

    @JsonProperty("soilHumiditySummer") val soilHumiditySummer: FiveDegreeScale? = null,

    @JsonProperty("soilHumidityWinter") val soilHumidityWinter: FiveDegreeScale? = null,

    @JsonProperty("airHumidity") val airHumidity: FiveDegreeScale? = null,

    @JsonProperty("airTemperatureSummer") val airTemperatureSummer: Int? = null,

    @JsonProperty("airTemperatureWinter") val airTemperatureWinter: Int? = null,

    @JsonProperty("lightIntensitySummer") val lightIntensitySummer: FiveDegreeScale? = null,

    @JsonProperty("lightIntensityWinter") val lightIntensityWinter: FiveDegreeScale? = null
) {

}

