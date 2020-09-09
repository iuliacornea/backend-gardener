package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.GardenerDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.GardenersApi
import org.openapitools.gardener.model.GardenerDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.CrossOrigin
import java.util.*

@CrossOrigin(origins = ["*"])
@Component
class GardenerController(private var service: GardenerDtoService, private var userService: UserService) : GardenersApi {

    override fun getGardeners(userToken: String): ResponseEntity<List<GardenerDto>> {
        var requester = userService.getUserByToken(userToken)
        var gardeners = service.getGardeners(requester)
        return ResponseEntity(gardeners, HttpStatus.OK)
    }

    override fun getGardener(userToken: String, id: UUID): ResponseEntity<GardenerDto> {
        var requester = userService.getUserByToken(userToken)
        var gardener = service.getGardener(id)
        if (requester == null || gardener == null || requester.id != gardener.userId) {
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
        return ResponseEntity(gardener, HttpStatus.OK)
    }
}
