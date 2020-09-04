package com.iulia.gardener.service.impl

import com.iulia.gardener.error.InvalidEmailAddress
import com.iulia.gardener.error.InvalidPassword
import com.iulia.gardener.error.UnauthorizedUserRole
import com.iulia.gardener.mapper.impl.UserMapper
import com.iulia.gardener.repo.UserRepository
import org.openapitools.gardener.model.UserDto
import org.openapitools.gardener.model.UserRole
import org.springframework.stereotype.Service

@Service
class UserService(var mapper: UserMapper, var repository: UserRepository) {

    fun emailUsed(userDto: UserDto): Boolean {
        return repository.existsByEmail(userDto.email)
    }

    fun signupUser(userDto: UserDto): UserDto {
        if(userDto.role != UserRole.USER) {
            throw UnauthorizedUserRole("New users can be only regular users. Admins for example are not allowed to sign up.")
        }
        if (emailUsed(userDto)) {
            throw InvalidEmailAddress("There is already an account for email address: ${userDto.email}. Sign up not possible")
        }
        if (userDto.password.length < 6) {
            throw InvalidPassword("Password must have at least 6 characters")
        }
        return mapper.toDto(repository.save(mapper.toEntity(userDto)))
    }

    fun loginUser(email: String, password: String): UserDto? {
        var user = repository.findByEmailAndPassword(email, password)
        var tokenCharPool = user.email + user.password
        if (user.token == null) {
            var newToken = (1..12).map { kotlin.random.Random.nextInt(0, tokenCharPool.length) }
                    .map(tokenCharPool::get)
                    .joinToString("");
            user.token = newToken
            user = repository.saveAndFlush(user)
        }
        return mapper.toDto(user)
    }

    fun logoutUser(token: String) {
        var user = repository.findByToken(token)
        user.token = null
        repository.saveAndFlush(user)
    }

    fun getUserByToken(token: String): UserDto {
        var user = repository.findByToken(token)
        return mapper.toDto(user)
    }

    fun isAdmin(userToken: String): Boolean {
        return repository.findByToken(userToken).role == UserRole.ADMIN;
    }

}
