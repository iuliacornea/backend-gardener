package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.entity.GrowingConfigurations
import com.iulia.gardener.mapper.impl.GrowingConfigurationsMapper
import org.openapitools.gardener.model.GrowingConfigurationDto
import com.iulia.gardener.repo.GrowingConfigurationsRepository
import com.iulia.gardener.service.GenericDtoService
import org.springframework.stereotype.Component
import java.util.*

@Component
class GrowingConfigurationDtoService(
        override var mapper: GrowingConfigurationsMapper,
        override var repository: GrowingConfigurationsRepository) :
        GenericDtoService<GrowingConfigurations, GrowingConfigurationDto, GrowingConfigurationsMapper, GrowingConfigurationsRepository>() {

    override fun getDtoId(dto: GrowingConfigurationDto): UUID? {
        return dto.id
    }

    fun getGlobalGrowingConfigurations(): List<GrowingConfigurationDto> {
        return repository.getAllByAppUserId(null)!!.map { mapper.toDto(it) }
    }

    fun getUserGrowingConfigurations(appUserUUID: UUID): List<GrowingConfigurationDto> {
        var growingConfigurations = mutableListOf<GrowingConfigurations>()
        growingConfigurations.addAll(repository.getAllByAppUserId(null) as Iterable<GrowingConfigurations>)
        growingConfigurations.addAll(repository.getAllByAppUserId(appUserUUID) as Iterable<GrowingConfigurations>)
        return growingConfigurations!!.map { mapper.toDto(it) }
    }
}
