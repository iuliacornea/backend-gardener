package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.FeaturesConfigurationDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.FeaturesApi
import org.openapitools.gardener.model.FeaturesConfigurationDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@Controller
class FeaturesController(var service: FeaturesConfigurationDtoService,
                         var userService: UserService) : FeaturesApi {

    override fun deleteFeatureConfiguration(@PathVariable(value = "id") id: UUID, @NotNull @RequestParam(required = true, value = "userToken") userToken: String): ResponseEntity<Unit> {
//        var resource = service.getOne(id)
//        if (resource?.userId == null && userService.isAdmin(userToken)) {
//            service.delete(id)
//            return ResponseEntity(HttpStatus.OK)
//        } else if (resource?.userId != null) {
//            var requester = userService.getUserByToken(userToken).id
//            var owner = resource.userId
//            if (requester == owner) {
//                service.delete(id)
//                return ResponseEntity(HttpStatus.OK)
//            }
//        }
//        return ResponseEntity(HttpStatus.UNAUTHORIZED)
        service.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun getFeatureConfiguration(id: UUID): ResponseEntity<FeaturesConfigurationDto> {
        var result = service.getOne(id)
        return if (result != null)
            ResponseEntity(result, HttpStatus.OK)
        else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

    override fun getFeatureConfigurations(): ResponseEntity<List<FeaturesConfigurationDto>> {
        var results = service.getAll()
        return ResponseEntity(results, HttpStatus.OK)
    }

    override fun postFeatureConfiguration(@NotNull @RequestParam(required = true, value = "userToken") userToken: String, @Valid @RequestBody featuresConfigurationDto: FeaturesConfigurationDto): ResponseEntity<FeaturesConfigurationDto> {
        var updated = service.save(featuresConfigurationDto)
        return ResponseEntity(updated, HttpStatus.OK)
    }
}
