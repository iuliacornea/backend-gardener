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
* Values: VERY_LOW,LOW,MEDIUM,HIGH,VERY_HIGH
*/
enum class FiveDegreeScale(val value: kotlin.String) {

    VERY_LOW("VERY_LOW"),

    LOW("LOW"),

    MEDIUM("MEDIUM"),

    HIGH("HIGH"),

    VERY_HIGH("VERY_HIGH");

}

