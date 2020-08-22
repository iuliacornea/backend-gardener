package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.GrowingConfigurationDtoService
import org.openapitools.gardener.api.GrowingConfigsApi
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class GrowingConfigurationsController(var service: GrowingConfigurationDtoService): GrowingConfigsApi {

    override fun deleteGrowingConfiguration(id: UUID): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun getGrowingConfiguration(id: UUID): ResponseEntity<GrowingConfigurationDto> {
        var result = service.getOne(id)
        return if (result != null)
            ResponseEntity(result, HttpStatus.OK)
        else
            ResponseEntity(HttpStatus.NOT_FOUND)
    }

    override fun getGrowingConfigurations(): ResponseEntity<List<GrowingConfigurationDto>> {
        var results = service.getAll()
        return ResponseEntity(results, HttpStatus.OK)
    }

    override fun postGrowingConfiguration(growingConfigurationDto: GrowingConfigurationDto): ResponseEntity<GrowingConfigurationDto> {
        var updated = service.save(growingConfigurationDto)
        return ResponseEntity(updated, HttpStatus.OK)
    }
}
