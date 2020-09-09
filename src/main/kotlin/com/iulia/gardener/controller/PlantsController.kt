package com.iulia.gardener.controller

import org.openapitools.gardener.model.PlantTypeDto
import com.iulia.gardener.service.impl.PlantTypeDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.PlantsApi
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
        var userVisiblePlants = mutableListOf<PlantTypeDto>();
        userVisiblePlants.addAll(plantTypeService.getGlobalPlantTypes())
        userVisiblePlants.addAll(plantTypeService.getAllByUserUuid(user.id!!) as Iterable<PlantTypeDto>)
        return ResponseEntity(userVisiblePlants, HttpStatus.OK)
    }

    override fun getPlant(id: UUID): ResponseEntity<PlantTypeDto> {
        var found = plantTypeService.getOne(id)
        return if (found != null) {
            ResponseEntity(found, HttpStatus.OK)
        } else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

    override fun postPlant(@NotNull @RequestParam(required = true, value = "userToken") userToken: String, @Valid @RequestBody plantTypeDto: PlantTypeDto): ResponseEntity<PlantTypeDto> {
        // will throw error if user is not found
        var user = userService.getUserByToken(userToken)
        if( userService.isAdmin(userToken)) {
            var globalPlantTypeDto = PlantTypeDto(
                    name = plantTypeDto.name,
                    userId = null,
                    id = plantTypeDto.id,
                    growingConfiguration = plantTypeDto.growingConfiguration,
                    image = plantTypeDto.image,
                    featuresConfiguration = plantTypeDto.featuresConfiguration,
                    description = plantTypeDto.description
            )
            var saved = plantTypeService.save(globalPlantTypeDto)
            return ResponseEntity(saved, HttpStatus.OK)
        } else {
            var saved = plantTypeService.save(plantTypeDto)
            return ResponseEntity(saved, HttpStatus.OK)
        }
    }

    override fun deletePlant(@PathVariable(value = "id") id: UUID, @NotNull @RequestParam(required = true, value = "userToken") userToken: String): ResponseEntity<Unit> {
        var resource = plantTypeService.getOne(id)
        if (resource?.userId == null && userService.isAdmin(userToken)) {
            plantTypeService.delete(id)
            return ResponseEntity(HttpStatus.OK)
        } else if (resource?.userId != null) {
            var requester = userService.getUserByToken(userToken).id
            var owner = resource.userId
            if (requester == owner) {
                plantTypeService.delete(id)
                return ResponseEntity(HttpStatus.OK)
            }
        }
        return ResponseEntity(HttpStatus.UNAUTHORIZED)
    }
}
