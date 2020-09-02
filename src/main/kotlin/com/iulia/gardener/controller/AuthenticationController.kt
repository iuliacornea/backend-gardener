package com.iulia.gardener.controller

import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.AuthenticationApi
import org.openapitools.gardener.model.UserDto
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller

@Controller
class AuthenticationController(var userService: UserService) : AuthenticationApi {

    override fun signUpUser(userDto: UserDto): ResponseEntity<UserDto> {
        if (userService.emailUsed(userDto)) {
            return ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
        }
        if (userDto.password.length < 6) {
            return ResponseEntity(HttpStatus.EXPECTATION_FAILED)
        }
        var newUserDto = userService.save(userDto)
        return ResponseEntity(newUserDto, HttpStatus.OK)
    }

    override fun loginUser(userDto: UserDto): ResponseEntity<UserDto> {
        try {
            var userWithToken = userService.loginUser(userDto.email, userDto.password)
            return ResponseEntity(userWithToken, HttpStatus.OK)
        } catch (exception : EmptyResultDataAccessException) {
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }

    override fun logoutUser(userToken: String): ResponseEntity<Unit> {
        try {
            userService.logoutUser(userToken)
        } catch (exception : EmptyResultDataAccessException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(HttpStatus.OK)
    }
}
