package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.GreenhouseStatsDtoService
import com.iulia.gardener.service.impl.SpecimenDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.GreenhouseApi
import org.openapitools.gardener.model.GreenhouseConfigDto
import org.openapitools.gardener.model.GreenhouseMessageDto
import org.openapitools.gardener.model.GreenhouseStatsDto
import org.openapitools.gardener.model.Season
import org.openapitools.gardener.model.SpecimenDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class GreenhouseController(
        private var service: GreenhouseStatsDtoService,
        private var specimenService: SpecimenDtoService,
        private var userService: UserService) : GreenhouseApi {

    override fun postStats(greenhouseMessageDto: GreenhouseMessageDto): ResponseEntity<GreenhouseConfigDto> {
        val greenhouseStatsDto = service.saveMessage(greenhouseMessageDto)
        return if (greenhouseStatsDto.specimenId != null) {
            val specimen = specimenService.getSpecimen(greenhouseStatsDto.specimenId)
            val greenhouseConfigDto = getSeasonConfig(specimen)
            ResponseEntity(greenhouseConfigDto, HttpStatus.OK)
        } else {
            val greenhouseConfigDto = GreenhouseConfigDto(
                    soilMoisture = 1024
            )
            ResponseEntity(greenhouseConfigDto, HttpStatus.OK)
        }
    }

    override fun getStats(userToken: String, gardenerId: UUID?, specimenId: UUID?): ResponseEntity<List<GreenhouseStatsDto>> {
        val requester = userService.getUserByToken(userToken)
        val greenhouseStats = service.getStats(requester, gardenerId, specimenId)
        return ResponseEntity(greenhouseStats, HttpStatus.OK)
    }

    private fun getSeasonConfig(specimen: SpecimenDto): GreenhouseConfigDto {
        if (isSummerSeason(specimen) && getSoilMoistureSummerMin(specimen) != null) {
            return GreenhouseConfigDto(
                    soilMoisture = getSoilMoistureSummerMin(specimen)
            )
        }
        if (isWinterSeason(specimen) && getSoilMoistureWinterMin(specimen) != null) {
            return GreenhouseConfigDto(
                    soilMoisture = getSoilMoistureWinterMin(specimen)
            )
        }
        return GreenhouseConfigDto(
                soilMoisture = 1024
        )
    }

    private fun isWinterSeason(specimen: SpecimenDto): Boolean {
        return specimen.season == Season.AUTUMN || specimen.season == Season.WINTER
    }

    private fun isSummerSeason(specimen: SpecimenDto): Boolean {
        return specimen.season == Season.SPRING || specimen.season == Season.SUMMER
    }

    private fun getSoilMoistureSummerMin(specimen: SpecimenDto): Int? {
        return specimen.growingConfiguration?.soilMoistureSummerMin
                ?: specimen.plantType?.growingConfiguration?.soilMoistureSummerMin
    }

    private fun getSoilMoistureWinterMin(specimen: SpecimenDto): Int? {
        return specimen.growingConfiguration?.soilMoistureWinterMin
                ?: specimen.plantType?.growingConfiguration?.soilMoistureWinterMin
    }


}
