package com.iulia.gardener.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.NotNull

/**
 * 
 * @param code 
 * @param message 
 */
data class Error(

    @get:NotNull
    @JsonProperty("code") val code: kotlin.Int,

    @get:NotNull 
    @JsonProperty("message") val message: kotlin.String
) {

}

