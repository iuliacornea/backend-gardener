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
* Values: USER,ADMIN
*/
enum class UserRole(val value: kotlin.String) {

    USER("USER"),

    ADMIN("ADMIN");

}

