package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
* 
* Values: SMOOTH,HAIRY,WARTY,PLEATED,ROUGHENED_RIDGES,GROOVED
*/
enum class LeafSurface(val value: kotlin.String) {

    SMOOTH("SMOOTH"),

    HAIRY("HAIRY"),

    WARTY("WARTY"),

    PLEATED("PLEATED"),

    ROUGHENED_RIDGES("ROUGHENED_RIDGES"),

    GROOVED("GROOVED");

}

