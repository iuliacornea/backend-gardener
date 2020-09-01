package com.iulia.gardener.controller

import org.openapitools.gardener.model.PlantTypeDto
import com.iulia.gardener.integration.impl.PlantTypeDtoService
import com.iulia.gardener.integration.impl.UserService
import org.openapitools.gardener.api.PlantsApi
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
class PlantsController(
        var plantTypeService: PlantTypeDtoService,
        var userService: UserService
) : PlantsApi {

    override fun getPlants(@RequestParam(required = false, value = "userToken") userToken: String?): ResponseEntity<List<PlantTypeDto>> {
        if (userToken == null) {
            return ResponseEntity(plantTypeService.getGlobalPlantTypes(), HttpStatus.OK)
        }
        // will throw error if user is not found
        var user = userService.getUserByToken(userToken)
        return ResponseEntity(plantTypeService.getAllByUserUuid(user.id!!), HttpStatus.OK)
    }

    override fun getPlant(id: UUID): ResponseEntity<PlantTypeDto> {
        var found = plantTypeService.getOne(id)
        return if (found != null) {
            ResponseEntity(found, HttpStatus.OK)
        } else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

    override fun postPlant(@NotNull @RequestParam(required = true, value = "userToken") userToken: String, @Valid @RequestBody plantTypeDto: PlantTypeDto): ResponseEntity<PlantTypeDto> {
        assert(userService.isAdmin(userToken))
        var saved = plantTypeService.save(plantTypeDto)
        return ResponseEntity(saved, HttpStatus.OK)
    }

    override fun deletePlant(@PathVariable(value = "id") id: UUID, @NotNull @RequestParam(required = true, value = "userToken") userToken: String): ResponseEntity<Unit> {
        plantTypeService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}
