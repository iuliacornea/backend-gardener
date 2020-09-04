package com.iulia.gardener.repo

import com.iulia.gardener.entity.Gardener
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GardenerRepository: JpaRepository<Gardener, UUID> {

    fun findAllByAppUserId(appUserId: UUID): List<Gardener>
}
