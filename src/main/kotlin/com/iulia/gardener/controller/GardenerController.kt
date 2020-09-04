package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.GardenerDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.GardenersApi
import org.openapitools.gardener.model.GardenerDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class GardenerController(private var service: GardenerDtoService, private var userService: UserService) : GardenersApi {

    override fun getGardeners(userToken: String): ResponseEntity<List<GardenerDto>> {
        var requester = userService.getUserByToken(userToken)
        var gardeners = service.getGardeners(requester)
        return ResponseEntity(gardeners, HttpStatus.OK)
    }
}
