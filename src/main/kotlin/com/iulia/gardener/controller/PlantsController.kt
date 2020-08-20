package com.iulia.gardener.controller

import com.iulia.gardener.api.PlantsApi
import com.iulia.gardener.model.Plant
import com.iulia.gardener.service.impl.FeaturesConfigurationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class PlantsController(
        var featuresConfigurationService: FeaturesConfigurationService
) : PlantsApi {

    override fun getPlants(): ResponseEntity<List<Plant>> {
        println("getting plants")
        var brad = Plant(
                id = UUID.randomUUID(),
                name = "Brad",
                description = "Am descris un brad"
        )
        var plants = listOf(brad)
        return ResponseEntity(plants, HttpStatus.OK)
    }

     override fun postPlant(plant: Plant): ResponseEntity<Plant> {
         if(plant.features != null) {
             featuresConfigurationService.save(plant.features!!)
             println("saved features")
         }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
