package com.iulia.gardener.integration.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.mapper.impl.FeaturesConfigurationMapper
import com.iulia.gardener.repo.FeaturesConfigurationRepository
import com.iulia.gardener.integration.GenericDtoService
import org.openapitools.gardener.model.FeaturesConfigurationDto
import org.springframework.stereotype.Service
import java.util.*

@Service
class FeaturesConfigurationDtoService(
        override var mapper: FeaturesConfigurationMapper,
        override var repository: FeaturesConfigurationRepository
): GenericDtoService<FeaturesConfiguration,
        FeaturesConfigurationDto, FeaturesConfigurationMapper, FeaturesConfigurationRepository>() {

    override fun getDtoId(dto: FeaturesConfigurationDto): UUID? {
        return dto.id
    }

}
