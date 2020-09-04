package com.iulia.gardener.repo

import com.iulia.gardener.entity.GardenerOrder
import org.openapitools.gardener.model.OrderStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GardenerOrderRepository: JpaRepository<GardenerOrder, UUID> {

    fun findAllByStatusIn(statuses: List<OrderStatus>): List<GardenerOrder>

    fun findAllByAppUserId(appUserId: UUID): List<GardenerOrder>

    fun findAllByAppUserIdAndStatusIn(appUserId: UUID, statuses: List<OrderStatus>): List<GardenerOrder>
}

