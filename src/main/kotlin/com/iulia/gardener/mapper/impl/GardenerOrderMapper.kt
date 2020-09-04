package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.GardenerOrder
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.GardenerOrderDto
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.OffsetDateTime

@Component
class GardenerOrderMapper: GenericMapper<GardenerOrderDto, GardenerOrder> {
    override fun toEntity(dto: GardenerOrderDto): GardenerOrder {
        return GardenerOrder(
                id = dto.id,
                createdAt = Timestamp.from(dto.createdAt.toInstant()),
                appUserId = dto.userId,
                gardenerName = dto.gardenerName,
                lastUpdate = Timestamp.from(dto.lastUpdate?.toInstant()),
                status = dto.status,
                wifiNetwork = dto.wifiNetwork,
                wifiPassword = dto.wifiPassword
        )
    }

    override fun toDto(entity: GardenerOrder): GardenerOrderDto {
        return GardenerOrderDto(
                id = entity.id,
                createdAt = OffsetDateTime.ofInstant(entity.createdAt.toInstant(), null),
                userId = entity.appUserId,
                gardenerName = entity.gardenerName,
                lastUpdate = OffsetDateTime.ofInstant(entity.lastUpdate?.toInstant(), null),
                status = entity.status,
                wifiNetwork = entity.wifiNetwork,
                wifiPassword = entity.wifiPassword
        )
    }
}
