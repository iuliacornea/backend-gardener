package com.iulia.gardener.repo

import com.iulia.gardener.entity.PlantType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PlantTypeRepository: JpaRepository<PlantType, UUID> {

    fun getAllByAppUserId(userUUID: UUID?): List<PlantType>?
}
