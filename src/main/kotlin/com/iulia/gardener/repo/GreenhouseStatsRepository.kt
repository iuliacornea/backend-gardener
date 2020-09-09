package com.iulia.gardener.repo

import com.iulia.gardener.entity.GreenhouseStats
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.sql.Timestamp
import java.util.*

@Repository
interface GreenhouseStatsRepository : JpaRepository<GreenhouseStats, UUID> {

    fun findAllByGardenerId(gardenerId: UUID): List<GreenhouseStats>

    fun findAllBySpecimenId(specimenId: UUID): List<GreenhouseStats>

    fun findAllByGardenerIdAndSpecimenId(gardenerId: UUID, specimenId: UUID): List<GreenhouseStats>

    fun findAllByUserId(userId: UUID): List<GreenhouseStats>

    fun findAllByGardenerIdAndSpecimenIdAndReceivedAtGreaterThan(gardenerId: UUID, specimenId: UUID, receivedAt: Timestamp): List<GreenhouseStats>
}
