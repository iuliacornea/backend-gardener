package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.FlowerExistance
import org.openapitools.gardener.model.FlowerPetals
import org.openapitools.gardener.model.FlowerShape
import org.openapitools.gardener.model.LeafArrangementOnTheStem
import org.openapitools.gardener.model.LeafDivisionOfBlade
import org.openapitools.gardener.model.LeafSurface
import org.openapitools.gardener.model.LeafTexture
import org.openapitools.gardener.model.LeafVeinType
import org.openapitools.gardener.model.StemSpikes
import org.openapitools.gardener.model.StemType
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
 * @param stemType 
 * @param stemSpikes 
 * @param leafDivisionOfBlade 
 * @param leafArrangementOnTheStem 
 * @param leafSurface 
 * @param leafTexture 
 * @param leafVeinType 
 * @param flowerExistance 
 * @param flowerShape 
 * @param flowerPetals 
 */
data class FeaturesConfigurationDto(

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("stemType") val stemType: StemType? = null,

    @JsonProperty("stemSpikes") val stemSpikes: StemSpikes? = null,

    @JsonProperty("leafDivisionOfBlade") val leafDivisionOfBlade: LeafDivisionOfBlade? = null,

    @JsonProperty("leafArrangementOnTheStem") val leafArrangementOnTheStem: LeafArrangementOnTheStem? = null,

    @JsonProperty("leafSurface") val leafSurface: LeafSurface? = null,

    @JsonProperty("leafTexture") val leafTexture: LeafTexture? = null,

    @JsonProperty("leafVeinType") val leafVeinType: LeafVeinType? = null,

    @JsonProperty("flowerExistance") val flowerExistance: FlowerExistance? = null,

    @JsonProperty("flowerShape") val flowerShape: FlowerShape? = null,

    @JsonProperty("flowerPetals") val flowerPetals: FlowerPetals? = null
) {

}

