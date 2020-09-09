package com.iulia.gardener.service.impl

import com.iulia.gardener.notification.MailSender
import org.openapitools.gardener.model.GardenerDto
import org.openapitools.gardener.model.GreenhouseStatsDto
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.openapitools.gardener.model.Season
import org.openapitools.gardener.model.SpecimenDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.OffsetDateTime
import java.util.*

@Component
class UserNotificationService(val mailSender: MailSender,
                              private val specimenDtoService: SpecimenDtoService,
                              private val gardenerDtoService: GardenerDtoService,
                              private val userService: UserService,
                              private val greenhouseStatsDtoService: GreenhouseStatsDtoService,
                              private val plantTypeDtoService: PlantTypeDtoService,
                              @Value("\${user-notifications-job.delay}") private val checkingInterval: Long) {


    @Scheduled(fixedRate = 30000)
    fun checkGreenhouseStatisticsAndNotifyUsers() {
        val gardeners = gardenerDtoService.getAllGardeners()
        val specimensWithGardener = specimenDtoService.getAllSpecimentWithGardenerIn(gardeners)
        val now = OffsetDateTime.now()
        specimensWithGardener.forEach {
            val lastStats = greenhouseStatsDtoService.findAllByGardenerIdAndSpecimenIdAndReceivedAtGreaterThan(
                    it.gardenerId!!, it.id!!, now.minusSeconds(checkingInterval))
            if (!lastStats.isEmpty()) {
                var averageSoilMoisture = 0
                for (stat: GreenhouseStatsDto in lastStats) {
                    averageSoilMoisture += stat.soilMoisturePercentage!!
                }
                averageSoilMoisture /= lastStats.size
                val configs = getGrowingConfigsOfSpecimen(it)
                if (((it.season == Season.SUMMER || it.season == Season.SPRING)
                                && configs?.soilMoistureSummerMin != null
                                && averageSoilMoisture < configs.soilMoistureSummerMin)
                        || ((it.season == Season.WINTER || it.season == Season.AUTUMN)
                                && configs?.soilMoistureWinterMin != null
                                && averageSoilMoisture < configs.soilMoistureWinterMin)) {
                    val userEmail = userService.getOneById(it.userId).email
                    println("send email for soil moisture too low")
                    mailSender.sendEmail(mailSender.composeSoilMoistureTooLowEmail(userEmail, getGardenerName(gardeners, it.gardenerId), it.name))
                }
            }

        }
    }

    private fun getGardenerName(gardeners: List<GardenerDto>, gardenerId: UUID): String {
        val gardener = gardeners.find { it.id == gardenerId }
        return if (gardener?.name != null) gardener.name else ""
    }

    private fun getGrowingConfigsOfSpecimen(specimen: SpecimenDto): GrowingConfigurationDto? {
        return when {
            specimen.plantType?.id != null -> {
                plantTypeDtoService.getOne(specimen.plantType!!.id!!)?.growingConfiguration
            }
            specimen.growingConfiguration != null -> {
                specimen.growingConfiguration
            }
            else -> {
                null
            }
        }
    }
}
