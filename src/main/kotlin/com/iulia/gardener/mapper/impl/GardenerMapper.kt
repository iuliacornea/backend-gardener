package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.Gardener
import com.iulia.gardener.entity.GardenerOrder
import com.iulia.gardener.mapper.GenericMapper
import com.iulia.gardener.repo.GardenerOrderRepository
import org.openapitools.gardener.model.GardenerDto
import org.openapitools.gardener.model.GardenerOrderDto
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.OffsetDateTime

@Component
class GardenerMapper(
        private var gardenerOrderMapper: GardenerOrderMapper
) {

    fun toEntityFromOrder(order: GardenerOrderDto): Gardener {
        return Gardener(
                name = order.gardenerName,
                wifiNetwork = order.wifiNetwork,
                wifiPassword = order.wifiPassword,
                appUserId = order.userId,
                order = gardenerOrderMapper.toEntity(order),
                createdAt = Timestamp.from(Instant.now())
        )
    }

    fun toDto(entity: Gardener): GardenerDto {
        return GardenerDto(
                id = entity.id,
                createdAt = OffsetDateTime.ofInstant(entity.createdAt.toInstant(), null),
                userId = entity.appUserId,
                name = entity.name,
                wifiNetwork = entity.wifiNetwork,
                wifiPassword = entity.wifiPassword,
                order = gardenerOrderMapper.toDto(entity.order)
        )
    }

}
