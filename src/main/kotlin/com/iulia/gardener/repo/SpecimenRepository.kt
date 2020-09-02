package com.iulia.gardener.repo

import com.iulia.gardener.entity.Specimen
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpecimenRepository : JpaRepository<Specimen, UUID> {

    fun getAllByAppUserId(appUserId: UUID): List<Specimen>?
}
