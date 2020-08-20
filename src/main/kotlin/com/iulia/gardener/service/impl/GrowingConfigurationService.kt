package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.GrowingConfigurations
import com.iulia.gardener.mapper.impl.GrowingConfigurationsMapper
import com.iulia.gardener.model.GrowingConfigurationDto
import com.iulia.gardener.repo.GrowingConfigurationsRepository
import com.iulia.gardener.service.GenericService
import org.springframework.stereotype.Component
import java.util.*

@Component
class GrowingConfigurationService(
        override var mapper: GrowingConfigurationsMapper,
        override var repository: GrowingConfigurationsRepository) :
        GenericService<GrowingConfigurations, GrowingConfigurationDto, GrowingConfigurationsMapper, GrowingConfigurationsRepository>() {

    override fun getDtoId(dto: GrowingConfigurationDto): UUID? {
        return dto.id
    }
}
