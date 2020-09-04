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
* Values: OPEN,PENDING_APPROVAL,APPROVED
*/
enum class OrderStatus(val value: kotlin.String) {

    OPEN("OPEN"),

    PENDING_APPROVAL("PENDING_APPROVAL"),

    APPROVED("APPROVED");

}

