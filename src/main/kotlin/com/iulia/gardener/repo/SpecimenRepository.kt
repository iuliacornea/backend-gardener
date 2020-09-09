package com.iulia.gardener.repo

import com.iulia.gardener.entity.Specimen
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpecimenRepository : JpaRepository<Specimen, UUID> {

    fun getAllByAppUserId(appUserId: UUID): List<Specimen>?

    fun findByGardenerId(gardenerId: UUID): Specimen?

    fun findAllByGardenerIdIn(gardenerIds: List<UUID>): List<Specimen>
}
