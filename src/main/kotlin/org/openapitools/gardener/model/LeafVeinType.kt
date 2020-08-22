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
* Values: ARCUATE,CROSS_VENULATE,DICHTOMOUS,LONGITUDINAL,PALMATE,PARALLEL,PINNATE,RETICULATE,ROTATE
*/
enum class LeafVeinType(val value: kotlin.String) {

    ARCUATE("ARCUATE"),

    CROSS_VENULATE("CROSS_VENULATE"),

    DICHTOMOUS("DICHTOMOUS"),

    LONGITUDINAL("LONGITUDINAL"),

    PALMATE("PALMATE"),

    PARALLEL("PARALLEL"),

    PINNATE("PINNATE"),

    RETICULATE("RETICULATE"),

    ROTATE("ROTATE");

}

