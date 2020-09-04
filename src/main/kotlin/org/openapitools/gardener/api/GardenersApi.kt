/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package org.openapitools.gardener.api

import org.openapitools.gardener.model.Error
import org.openapitools.gardener.model.GardenerDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@Validated
@RequestMapping("\${api.base-path:/v1}")
interface GardenersApi {


    @RequestMapping(
            value = ["/gardeners"],
            produces = ["application/json"], 
            method = [RequestMethod.GET])
    fun getGardeners(@NotNull  @RequestParam(value = "userToken", required = true) userToken: kotlin.String
): ResponseEntity<List<GardenerDto>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
