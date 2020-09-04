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
 * @param username 
 * @param role 
 * @param id 
 * @param token 
 */
data class UserDto(

    @get:NotNull 
    @JsonProperty("email") val email: kotlin.String,

    @get:NotNull 
    @JsonProperty("password") val password: kotlin.String,

    @get:NotNull 
    @JsonProperty("username") val username: kotlin.String,

    @get:NotNull 
    @JsonProperty("role") val role: UserRole,

    @JsonProperty("id") val id: java.util.UUID? = null,

    @JsonProperty("token") val token: kotlin.String? = null
) {

}

