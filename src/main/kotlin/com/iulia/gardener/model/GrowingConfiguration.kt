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
data class GrowingConfiguration(

    @JsonProperty("soilType") val soilType: SoilType? = null,

    @JsonProperty("soilQuantity") val soilQuantity: java.math.BigDecimal? = null,

    @JsonProperty("soilHumiditySummer") val soilHumiditySummer: FiveDegreeScale? = null,

    @JsonProperty("soilHumidityWinter") val soilHumidityWinter: FiveDegreeScale? = null,

    @JsonProperty("airHumidity") val airHumidity: FiveDegreeScale? = null,

    @JsonProperty("airTemperatureSummer") val airTemperatureSummer: java.math.BigDecimal? = null,

    @JsonProperty("airTemperatureWinter") val airTemperatureWinter: java.math.BigDecimal? = null,

    @JsonProperty("lightIntensitySummer") val lightIntensitySummer: FiveDegreeScale? = null,

    @JsonProperty("lightIntensityWinter") val lightIntensityWinter: FiveDegreeScale? = null
) {

}

