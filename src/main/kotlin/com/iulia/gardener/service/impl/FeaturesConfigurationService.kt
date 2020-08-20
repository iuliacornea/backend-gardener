package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.FeaturesConfiguration
import com.iulia.gardener.mapper.impl.FeaturesConfigurationMapper
import com.iulia.gardener.model.PlantFeature
import com.iulia.gardener.repo.FeaturesConfigurationRepository
import com.iulia.gardener.service.GenericService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FeaturesConfigurationService(
        override var mapper: FeaturesConfigurationMapper,
        override var repository: FeaturesConfigurationRepository
): GenericService<FeaturesConfiguration,
        PlantFeature, FeaturesConfigurationMapper, FeaturesConfigurationRepository>() {

    override fun getDtoId(dto: PlantFeature): UUID? {
        return dto.id
    }

}
