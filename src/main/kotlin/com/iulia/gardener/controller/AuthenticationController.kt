package com.iulia.gardener.controller

import com.iulia.gardener.error.InvalidEmailAddress
import com.iulia.gardener.error.InvalidPassword
import com.iulia.gardener.error.UnauthorizedUserRole
import com.iulia.gardener.service.impl.UserService
import org.openapitools.gardener.api.AuthenticationApi
import org.openapitools.gardener.model.UserDto
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin(origins = ["*"])
@Controller
class AuthenticationController(var userService: UserService) : AuthenticationApi {

    override fun signUpUser(userDto: UserDto): ResponseEntity<UserDto> {
        try {
            var userWithToken = userService.signupUser(userDto)
            return ResponseEntity(userWithToken, HttpStatus.OK)
        } catch (e: InvalidEmailAddress) {
            return ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
        } catch (e: InvalidPassword) {
            return ResponseEntity(HttpStatus.EXPECTATION_FAILED)
        } catch (e: UnauthorizedUserRole) {
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }

    override fun loginUser(userDto: UserDto): ResponseEntity<UserDto> {
        try {
            var userWithToken = userService.loginUser(userDto.email, userDto.password)
            return ResponseEntity(userWithToken, HttpStatus.OK)
        } catch (exception: EmptyResultDataAccessException) {
            return ResponseEntity(HttpStatus.UNAUTHORIZED)
        }
    }

    override fun logoutUser(userToken: String): ResponseEntity<Unit> {
        try {
            userService.logoutUser(userToken)
        } catch (exception: EmptyResultDataAccessException) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return ResponseEntity(HttpStatus.OK)
    }
}
