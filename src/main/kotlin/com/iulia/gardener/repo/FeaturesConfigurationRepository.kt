package com.iulia.gardener.repo

import com.iulia.gardener.entity.FeaturesConfiguration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeaturesConfigurationRepository: JpaRepository<FeaturesConfiguration, UUID> {

    fun getAllByAppUserId(appUserId: UUID?): List<FeaturesConfiguration>?
}
