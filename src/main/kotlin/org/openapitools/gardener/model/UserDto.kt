package org.openapitools.gardener.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.gardener.model.UserRole
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param email 
 * @param password 
 * @param id 
 * @param username 
 * @param token 
 * @param role 
 */
data class UserDto(

    @get:NotNull 
    @JsonProperty("email") val email: kotlin.String,

    @get:NotNull 
    @JsonProperty("password") val password: kotlin.String,

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("username") val username: kotlin.String? = null,

    @JsonProperty("token") val token: kotlin.String? = null,

    @JsonProperty("role") val role: UserRole? = null
) {

}

