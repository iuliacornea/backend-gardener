package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.GrowingConfigurationDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.GrowingConfigsApi
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@CrossOrigin(origins = ["*"])
@Controller
class GrowingConfigurationsController(var service: GrowingConfigurationDtoService,
var userService: UserService): GrowingConfigsApi {

    override fun deleteGrowingConfiguration(@PathVariable(value = "id") id: UUID, @NotNull @RequestParam(required = true, value = "userToken") userToken: String): ResponseEntity<Unit> {
        var resource = service.getOne(id)
        if (resource?.userId == null && userService.isAdmin(userToken)) {
            service.delete(id)
            return ResponseEntity(HttpStatus.OK)
        } else if (resource?.userId != null) {
            var requester = userService.getUserByToken(userToken).id
            var owner = resource.userId
            if (requester == owner) {
                service.delete(id)
                return ResponseEntity(HttpStatus.OK)
            }
        }
        return ResponseEntity(HttpStatus.UNAUTHORIZED)
    }

    override fun getGrowingConfiguration(id: UUID): ResponseEntity<GrowingConfigurationDto> {
        var result = service.getOne(id)
        return if (result != null)
            ResponseEntity(result, HttpStatus.OK)
        else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

    override fun getGrowingConfigurations(): ResponseEntity<List<GrowingConfigurationDto>> {
        var results = service.getAll()
        return ResponseEntity(results, HttpStatus.OK)
    }

    override fun postGrowingConfiguration(@NotNull @RequestParam(required = true, value = "userToken") userToken: String, @Valid @RequestBody growingConfigurationDto: GrowingConfigurationDto): ResponseEntity<GrowingConfigurationDto> {
        var updated = service.save(growingConfigurationDto)
        return ResponseEntity(updated, HttpStatus.OK)
    }
}
