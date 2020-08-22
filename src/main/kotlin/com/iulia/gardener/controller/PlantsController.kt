package com.iulia.gardener.controller

import com.iulia.gardener.api.PlantsApi
import com.iulia.gardener.model.PlantTypeDto
import com.iulia.gardener.service.impl.FeaturesConfigurationService
import com.iulia.gardener.service.impl.PlantTypeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class PlantsController(
        var featuresConfigurationService: FeaturesConfigurationService,
        var plantTypeService: PlantTypeService
) : PlantsApi {

    override fun getPlants(): ResponseEntity<List<PlantTypeDto>> {
        println("getting all plants")
        var plants = plantTypeService.getAll()
        return ResponseEntity(plants, HttpStatus.OK)
    }

    override fun getPlant(id: UUID): ResponseEntity<PlantTypeDto> {
        var found = plantTypeService.getOne(id)
        if( found != null) {
            return ResponseEntity(found, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

     override fun postPlant(plantTypeDto: PlantTypeDto): ResponseEntity<PlantTypeDto> {
        var saved = plantTypeService.save(plantTypeDto)
        return ResponseEntity(saved, HttpStatus.OK)
    }
}
