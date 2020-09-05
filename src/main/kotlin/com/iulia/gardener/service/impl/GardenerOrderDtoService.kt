package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.GardenerOrder
import com.iulia.gardener.error.InvalidOrderCreate
import com.iulia.gardener.error.UnauthorizedOrderUpdate
import com.iulia.gardener.mapper.impl.GardenerOrderMapper
import com.iulia.gardener.repo.GardenerOrderRepository
import org.openapitools.gardener.model.GardenerOrderDto
import org.openapitools.gardener.model.OrderStatus
import org.openapitools.gardener.model.UserDto
import org.openapitools.gardener.model.UserRole
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant
import java.time.OffsetDateTime

@Service
class GardenerOrderDtoService(
        private var repository: GardenerOrderRepository,
        private var mapper: GardenerOrderMapper,
        private var gardenerDtoService: GardenerDtoService) {

    fun getOrders(requester: UserDto, statuses: List<OrderStatus>?): List<GardenerOrderDto> {
        if (requester.role == UserRole.ADMIN) {
            if (statuses == null || statuses.isEmpty()) {
                return repository.findAll().map { mapper.toDto(it) }
            }
            return repository.findAllByStatusIn(statuses).map { mapper.toDto(it) }
        }
        if (statuses == null || statuses.isEmpty()) {
            return repository.findAllByAppUserId(requester.id!!).map { mapper.toDto(it) }
        }
        return repository.findAllByStatusIn(statuses).map { mapper.toDto(it) }
    }

    fun processOrder(orderDto: GardenerOrderDto, requester: UserDto): GardenerOrderDto {
        return if (orderDto.id == null) {
            createOrder(orderDto)
        } else {
            updateOrder(orderDto, requester)
        }
    }

    private fun createOrder(orderDto: GardenerOrderDto): GardenerOrderDto {
        validateForCreation(orderDto)
        var newEntity = mapper.toEntity(orderDto)
        newEntity.createdAt = Timestamp.from(Instant.now())
        newEntity.status = OrderStatus.PENDING_APPROVAL
        newEntity.lastUpdate = Timestamp.from(Instant.now())
        return save(newEntity)
    }

    private fun validateForCreation(orderDto: GardenerOrderDto) {
        if (orderDto.id != null) {
            throw InvalidOrderCreate("Can not create an order with a given id")
        }
        if (orderDto.createdAt != null) {
            throw InvalidOrderCreate("Can not create an order with a given creation date")
        }
        if (orderDto.status != null && orderDto.status != OrderStatus.PENDING_APPROVAL) {
            throw InvalidOrderCreate("Can not create an order with status ${orderDto.status}")
        }
    }

    private fun updateOrder(orderDto: GardenerOrderDto, requester: UserDto): GardenerOrderDto {
        var createGardener = shouldCreateGardener(orderDto)
        validateForUpdate(orderDto, requester)
        var entity = mapper.toEntity(orderDto)
        entity.lastUpdate = Timestamp.from(Instant.now())
        var updatedOrder = save(entity)
        if(createGardener) {
            gardenerDtoService.createFromOrder(updatedOrder)
        }
        return updatedOrder
    }

    private fun shouldCreateGardener(orderDto: GardenerOrderDto): Boolean {
        return orderDto.status == OrderStatus.COMPLETED
                && orderDto.id != null
                && repository.getOne(orderDto.id).status != OrderStatus.COMPLETED;
    }

    private fun validateForUpdate(orderDto: GardenerOrderDto, requester: UserDto) {
        var oldValue = repository.getOne(orderDto.id!!)
        if (oldValue.status == OrderStatus.COMPLETED) {
            throw UnauthorizedOrderUpdate("This order is in status completed. No more updates are accepted")
        }
        if (requester.role == UserRole.ADMIN) {
            return
        }
        if (requester.id != orderDto.userId) {
            throw UnauthorizedOrderUpdate("User does not have the right to update this order")
        }
        if (oldValue.status != orderDto.status && !listOf(OrderStatus.MODIFIED_PENDING_APPROVAL, OrderStatus.CANCELLED).contains(orderDto.status)) {
            throw UnauthorizedOrderUpdate("User is not allowed to update the order to this status")
        }
    }

    private fun save(entity: GardenerOrder): GardenerOrderDto {
        return mapper.toDto(repository.saveAndFlush(entity))
    }

}
