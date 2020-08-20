package com.iulia.gardener.controller

import com.iulia.gardener.api.PlantsApi
import com.iulia.gardener.model.PlantTypeDto
import com.iulia.gardener.service.impl.FeaturesConfigurationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class PlantsController(
        var featuresConfigurationService: FeaturesConfigurationService
) : PlantsApi {

    override fun getPlants(): ResponseEntity<List<PlantTypeDto>> {
        println("getting plants")
        var plants = emptyList<PlantTypeDto>()
        return ResponseEntity(plants, HttpStatus.OK)
    }

     override fun postPlant(plantTypeDto: PlantTypeDto): ResponseEntity<PlantTypeDto> {
         if(plantTypeDto.featuresConfiguration != null) {
             featuresConfigurationService.save(plantTypeDto.featuresConfiguration!!)
             println("saved features")
         }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
