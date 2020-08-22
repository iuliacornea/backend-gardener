package com.iulia.gardener.controller

import org.openapitools.gardener.model.PlantTypeDto
import com.iulia.gardener.service.impl.FeaturesConfigurationDtoService
import com.iulia.gardener.service.impl.PlantTypeDtoService
import org.openapitools.gardener.api.PlantsApi
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class PlantsController(
        var plantTypeService: PlantTypeDtoService
) : PlantsApi {

    override fun getPlants(): ResponseEntity<List<PlantTypeDto>> {
        var plants = plantTypeService.getAll()
        return ResponseEntity(plants, HttpStatus.OK)
    }

    override fun getPlant(id: UUID): ResponseEntity<PlantTypeDto> {
        var found = plantTypeService.getOne(id)
        return if( found != null) {
            ResponseEntity(found, HttpStatus.OK)
        } else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

     override fun postPlant(plantTypeDto: PlantTypeDto): ResponseEntity<PlantTypeDto> {
        var saved = plantTypeService.save(plantTypeDto)
        return ResponseEntity(saved, HttpStatus.OK)
    }

    override fun deletePlant(id: UUID): ResponseEntity<Unit> {
        plantTypeService.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }
}
