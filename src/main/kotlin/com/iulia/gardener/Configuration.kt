package com.iulia.gardener

import com.iulia.gardener.entity.Specimen
import com.iulia.gardener.service.impl.GardenerDtoService
import com.iulia.gardener.service.impl.GreenhouseStatsDtoService
import com.iulia.gardener.service.impl.GrowingConfigurationDtoService
import com.iulia.gardener.service.impl.PlantTypeDtoService
import com.iulia.gardener.service.impl.SpecimenDtoService
import com.iulia.gardener.service.impl.UserService
import com.sendgrid.Email
import org.openapitools.gardener.model.GreenhouseStatsDto
import org.openapitools.gardener.model.GrowingConfigurationDto
import org.openapitools.gardener.model.Season
import org.openapitools.gardener.model.SpecimenDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled
import java.time.OffsetDateTime
import java.util.*

@Configuration
class Configuration(
        @Value("\${spring.sendgrid.verified-email}") private val sendGridVerifiedEmail: String
) {

    @Bean
    fun sendGridVerifiedEmail(): Email {
        return Email(sendGridVerifiedEmail)
    }

}
