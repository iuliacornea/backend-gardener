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
* Values: PENDING_APPROVAL,APPROVED,MODIFIED_PENDING_APPROVAL,CANCELLED,COMPLETED
*/
enum class OrderStatus(val value: kotlin.String) {

    PENDING_APPROVAL("PENDING_APPROVAL"),

    APPROVED("APPROVED"),

    MODIFIED_PENDING_APPROVAL("MODIFIED_PENDING_APPROVAL"),

    CANCELLED("CANCELLED"),

    COMPLETED("COMPLETED");

}

