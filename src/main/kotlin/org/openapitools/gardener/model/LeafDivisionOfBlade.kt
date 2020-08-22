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
* Values: SIMPLE,WITH_LEAFLETS,PINNATE_COMPOUND,PALMATE_COMPOUND,DOUBLE_COMPOUND
*/
enum class LeafDivisionOfBlade(val value: kotlin.String) {

    SIMPLE("SIMPLE"),

    WITH_LEAFLETS("WITH_LEAFLETS"),

    PINNATE_COMPOUND("PINNATE_COMPOUND"),

    PALMATE_COMPOUND("PALMATE_COMPOUND"),

    DOUBLE_COMPOUND("DOUBLE_COMPOUND");

}

