package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.FeaturesConfigurationDtoService
import org.openapitools.gardener.api.FeaturesApi
import org.openapitools.gardener.model.FeaturesConfigurationDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class FeaturesController( var service: FeaturesConfigurationDtoService): FeaturesApi {

    override fun deleteFeatureConfiguration(id: UUID): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun getFeatureConfiguration(id: UUID): ResponseEntity<FeaturesConfigurationDto> {
        var result = service.getOne(id)
        return if (result != null)
            ResponseEntity(result, HttpStatus.OK)
        else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

    override fun getFeatureConfigurations(): ResponseEntity<List<FeaturesConfigurationDto>> {
        var results = service.getAll()
        return ResponseEntity(results, HttpStatus.OK)
    }

    override fun postFeatureConfiguration(featuresConfigurationDto: FeaturesConfigurationDto): ResponseEntity<FeaturesConfigurationDto> {
        var updated = service.save(featuresConfigurationDto)
        return ResponseEntity(updated, HttpStatus.OK)
    }
}
