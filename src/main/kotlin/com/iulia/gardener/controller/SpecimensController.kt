package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.SpecimenDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.SpecimensApi
import org.openapitools.gardener.model.SpecimenDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class SpecimensController(var specimenDtoService: SpecimenDtoService, var userService: UserService) : SpecimensApi {

    override fun getSpecimens(userToken: String): ResponseEntity<List<SpecimenDto>> {
        var userId = userService.getUserByToken(userToken).id
        var result = specimenDtoService.getSpecimens(userId!!)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun getSpecimen(id: UUID, userToken: String): ResponseEntity<SpecimenDto> {
        assert(userService.getUserByToken(userToken).id == id)
        var result = specimenDtoService.getSpecimen(id)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun postSpecimen(userToken: String, specimenDto: SpecimenDto): ResponseEntity<SpecimenDto> {
        assert(userService.getUserByToken(userToken).id == specimenDto.userId)
        var result = specimenDtoService.saveSpecimen(specimenDto)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun deleteSpecimen(id: UUID, userToken: String): ResponseEntity<Unit> {
        specimenDtoService.deleteSpecimen(id)
        return ResponseEntity(HttpStatus.OK)
    }
}
