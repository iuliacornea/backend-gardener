package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.mapper.impl.FeaturesConfigurationMapper
import com.iulia.gardener.model.FeaturesConfigurationDto
import com.iulia.gardener.repo.FeaturesConfigurationRepository
import com.iulia.gardener.service.GenericService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FeaturesConfigurationService(
        override var mapper: FeaturesConfigurationMapper,
        override var repository: FeaturesConfigurationRepository
): GenericService<FeaturesConfiguration,
        FeaturesConfigurationDto, FeaturesConfigurationMapper, FeaturesConfigurationRepository>() {

    override fun getDtoId(dto: FeaturesConfigurationDto): UUID? {
        return dto.id
    }

}
