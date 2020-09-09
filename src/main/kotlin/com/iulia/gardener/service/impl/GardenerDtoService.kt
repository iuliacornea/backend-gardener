package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.Gardener
import com.iulia.gardener.mapper.impl.GardenerMapper
import com.iulia.gardener.repo.GardenerRepository
import org.openapitools.gardener.model.GardenerDto
import org.openapitools.gardener.model.GardenerOrderDto
import org.openapitools.gardener.model.UserDto
import org.openapitools.gardener.model.UserRole
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Service
class GardenerDtoService(private var mapper: GardenerMapper, private var repository: GardenerRepository) {

    fun createFromOrder(order: GardenerOrderDto): Gardener {
        var fromOrder = mapper.toEntityFromOrder(order)
        return repository.saveAndFlush(fromOrder)
    }

    fun getGardeners(requester: UserDto): List<GardenerDto> {
        if (requester.role == UserRole.ADMIN) {
            return repository.findAll().map { mapper.toDto(it) }
        }
        return repository.findAllByAppUserId(requester.id!!).map { mapper.toDto(it) }
    }

    fun getGardener(gardenerId: UUID): GardenerDto {
        return mapper.toDto(repository.getOne(gardenerId))
    }

    fun getAllGardeners(): List<GardenerDto> {
        return repository.findAll().map { mapper.toDto(it) }
    }

}
