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

    @Query("select s from Specimen s where s.gardener.id = :gardenerId")
    fun findByGardenerId(@Param(value = "gardenerId") gardenerId: UUID): Specimen?
}
