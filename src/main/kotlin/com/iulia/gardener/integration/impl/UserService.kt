package com.iulia.gardener.integration.impl

import com.iulia.gardener.entity.AppUser
import com.iulia.gardener.mapper.impl.UserMapper
import com.iulia.gardener.repo.UserRepository
import com.iulia.gardener.integration.GenericDtoService
import org.openapitools.gardener.model.UserDto
import org.springframework.stereotype.Service
import java.security.InvalidKeyException
import java.util.*

@Service
class UserService(override var mapper: UserMapper, override var repository: UserRepository) :
        GenericDtoService<AppUser, UserDto, UserMapper, UserRepository>() {

    fun emailUsed(userDto: UserDto): Boolean {
        return repository.existsByEmail(userDto.email)
    }

    fun loginUser(email: String, password: String): UserDto? {
        var user = repository.findByEmailAndPassword(email, password)
        var tokenCharPool = user.email + user.password
        if (user.token == null) {
            var newToken = (1..6).map { kotlin.random.Random.nextInt(0, tokenCharPool.length) }
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

    override fun getDtoId(dto: UserDto): UUID? {
        return dto.id
    }

    fun isAdmin(userToken: String): Boolean {
        return getUserByToken(userToken).email == "iulia.cornea5@gmail.com";
    }

}
