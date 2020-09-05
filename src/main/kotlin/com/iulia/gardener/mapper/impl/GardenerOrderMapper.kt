package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.GardenerOrder
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.GardenerOrderDto
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.OffsetDateTime
import java.time.ZoneId

@Component
class GardenerOrderMapper : GenericMapper<GardenerOrderDto, GardenerOrder> {
    override fun toEntity(dto: GardenerOrderDto): GardenerOrder {
        var createdAt: Timestamp? = null
        if (dto.createdAt != null) {
            createdAt = Timestamp.from(dto.createdAt.toInstant())
        }
        var lastUpdate: Timestamp? = null
        if (dto.lastUpdate != null) {
            lastUpdate = Timestamp.from(dto.lastUpdate.toInstant())
        }
        return GardenerOrder(
                id = dto.id,
                createdAt = createdAt,
                appUserId = dto.userId,
                gardenerName = dto.gardenerName,
                lastUpdate = lastUpdate,
                status = dto.status,
                wifiNetwork = dto.wifiNetwork,
                wifiPassword = dto.wifiPassword
        )
    }

    override fun toDto(entity: GardenerOrder): GardenerOrderDto {
        return GardenerOrderDto(
                id = entity.id,
                createdAt = OffsetDateTime.ofInstant(entity.createdAt!!.toInstant(), ZoneId.systemDefault()),
                userId = entity.appUserId,
                gardenerName = entity.gardenerName,
                lastUpdate = OffsetDateTime.ofInstant(entity.lastUpdate!!.toInstant(), ZoneId.systemDefault()),
                status = entity.status,
                wifiNetwork = entity.wifiNetwork,
                wifiPassword = entity.wifiPassword
        )
    }
}
