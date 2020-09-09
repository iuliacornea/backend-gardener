package com.iulia.gardener.controller

import com.iulia.gardener.error.InvalidOrderCreate
import com.iulia.gardener.error.UnauthorizedOrderUpdate
import com.iulia.gardener.service.impl.GardenerOrderDtoService
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.OrdersApi
import org.openapitools.gardener.model.GardenerOrderDto
import org.openapitools.gardener.model.OrderStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import java.util.*

@CrossOrigin(origins = ["*"])
@Controller
class GardenerOrderController(private var service: GardenerOrderDtoService, private var userService: UserService) : OrdersApi {

    override fun getOrders(userToken: String, status: List<OrderStatus>?): ResponseEntity<List<GardenerOrderDto>> {
        var requester = userService.getUserByToken(userToken)
        var orders = service.getOrders(requester, status)
        return ResponseEntity(orders, HttpStatus.OK)
    }

    override fun postOrder(userToken: String, gardenerOrderDto: GardenerOrderDto): ResponseEntity<GardenerOrderDto> {
        var requester = userService.getUserByToken(userToken)
        try {
            var newValue = service.processOrder(gardenerOrderDto, requester)
            return ResponseEntity(newValue, HttpStatus.OK)
        } catch (e: InvalidOrderCreate) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        } catch (e: UnauthorizedOrderUpdate) {
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }
}
