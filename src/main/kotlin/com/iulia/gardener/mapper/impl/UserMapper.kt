package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.AppUser
import org.openapitools.gardener.model.UserDto
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun toEntity(dto: UserDto): AppUser {
        return AppUser(
                id = dto.id,
                email = dto.email,
                username = dto.username,
                password = dto.password,
                token = dto.token,
                role = dto.role
        )
    }

    fun toDto(entity: AppUser): UserDto {
        return UserDto(
                id = entity.id,
                email = entity.email,
                username = entity.username,
                password = entity.password,
                token = entity.token,
                role = entity.role
        )
    }
}
