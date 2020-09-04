package com.iulia.gardener.repo

import com.iulia.gardener.entity.GrowingConfiguration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GrowingConfigurationsRepository: JpaRepository<GrowingConfiguration, UUID> {

    fun getAllByAppUserId(appUserId: UUID?): List<GrowingConfiguration>?
}
