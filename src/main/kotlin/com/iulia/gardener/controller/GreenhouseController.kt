package com.iulia.gardener.controller

import org.openapitools.gardener.api.GreenhouseApi
import org.openapitools.gardener.model.GreenhouseConfigDto
import org.openapitools.gardener.model.GreenhouseMessageDto
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller

@Controller
class GreenhouseController: GreenhouseApi {

    override fun postStats(greenhouseMessageDto: GreenhouseMessageDto): ResponseEntity<GreenhouseConfigDto> {
        return super.postStats(greenhouseMessageDto)
    }
}
