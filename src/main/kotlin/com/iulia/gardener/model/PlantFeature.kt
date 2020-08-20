package com.iulia.gardener.model

import com.fasterxml.jackson.annotation.JsonProperty

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
data class PlantFeature(

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

