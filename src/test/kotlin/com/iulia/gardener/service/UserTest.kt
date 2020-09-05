package com.iulia.gardener.service

import org.junit.jupiter.api.Test
import org.openapitools.gardener.model.UserDto
import org.openapitools.gardener.model.UserRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.PropertySource
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySource("classpath:src/test/resources/application.properties")
class UserTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun createUser() {
        var userDto = UserDto(
                email = "test1@email.com",
                password = "password123",
                username = "test1",
                role = UserRole.USER
        )
        var response = restTemplate.postForEntity("/v1/users/signup", userDto, UserDto::class.java)

        assert(response != null)
        assert(response.hasBody())
        var createdUser = response.body!!
        assert(createdUser.email == (userDto.email))
        assert(createdUser.password == (userDto.password))
        assert(createdUser.username == (userDto.username))
    }

    @Test
    fun emailAlreadyUsed() {
        var userDto = UserDto(
                email = "test2@email.com",
                password = "password123"
        )
        var response = restTemplate.postForEntity("/v1/users/signup", userDto, UserDto::class.java)
        assert(response.hasBody())

        var response2 = restTemplate.postForEntity("/v1/users/signup", userDto, String::class.java)
        assert(response2.statusCode == (HttpStatus.NOT_ACCEPTABLE))
    }

    @Test
    fun loginUserWithValidCredentials() {
        var userDto = UserDto(
                email = "test3@email.com",
                password = "password123",
                username = "test3",
                role = UserRole.USER
        )
        var response = restTemplate.postForEntity("/v1/users/signup", userDto, UserDto::class.java)
        assert(response.hasBody())

        var token = restTemplate.postForEntity("/v1/users/login", userDto, String::class.java)
        assert(token.hasBody())
    }

    @Test
    fun loginUserWithInvalidCredentials() {
        var userDto = UserDto(
                email = "test4@email.com",
                password = "password123",
                username = "test4",
                role = UserRole.USER
        )
        var response = restTemplate.postForEntity("/v1/users/signup", userDto, UserDto::class.java)
        assert(response.hasBody())

        var invalidCredentials = UserDto(
                username = "user with invalid pass",
                email = response.body!!.email,
                password = "invalid password",
                role = UserRole.USER
        )
        var response2 = restTemplate.postForEntity("/v1/users/login", invalidCredentials, String::class.java)
        assert(response2.statusCode == (HttpStatus.UNAUTHORIZED))
    }

    @Test
    fun invalidPassword() {
        // password must be at least 6 characters
        var userDto = UserDto(
                email = "test5@email.com",
                password = "pass",
                username = "test5",
                role = UserRole.USER
        )
        var response = restTemplate.postForEntity("/v1/users/signup", userDto, UserDto::class.java)
        assert(response.statusCode == (HttpStatus.EXPECTATION_FAILED))
    }

    @Test
    fun logout() {
        var userDto = UserDto(
                email = "test6@email.com",
                password = "password123",
                username = "test6",
                role = UserRole.USER
        )
        var signUpResponse = restTemplate.postForEntity("/v1/users/signup", userDto, UserDto::class.java)
        assert(signUpResponse.hasBody())
        var loginResponse = restTemplate.postForEntity("/v1/users/login", userDto, UserDto::class.java)
        assert(loginResponse.hasBody())
        assert(loginResponse.body!!.token != null)
        var token = loginResponse.body!!.token
        var logoutResponse = restTemplate.postForEntity("/v1/users/logout?userToken=" + token, null, String::class.java)
        assert(logoutResponse.statusCode == HttpStatus.OK)
        var invalidLogoutResponse = restTemplate.postForEntity("/v1/users/logout?userToken=" + token, null, String::class.java)
        assert(invalidLogoutResponse.statusCode == HttpStatus.NOT_FOUND)
    }

    @Test
    fun adminUserNotAllowedToSignup() {
        var admin = UserDto(
                username = "someone as admin",
                email = "admin@email.com",
                password = "more than 6 characters",
                role = UserRole.ADMIN
        )

        var signUpResponse = restTemplate.postForEntity("/v1/users/signup", admin, String::class.java)
        assert(signUpResponse.statusCode == HttpStatus.UNAUTHORIZED)
    }

}
