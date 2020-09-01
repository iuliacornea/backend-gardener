package com.iulia.gardener.mapper.impl

import com.iulia.gardener.entity.AppUser
import com.iulia.gardener.mapper.GenericMapper
import org.openapitools.gardener.model.UserDto
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller

@Component
class UserMapper : GenericMapper<UserDto, AppUser> {
    override fun toEntity(dto: UserDto): AppUser {
        return AppUser(
                id = dto.id,
                email = dto.email,
                username = dto.username,
                password = dto.password,
                token = dto.token
        )
    }

    override fun toDto(entity: AppUser): UserDto {
        return UserDto(
                id = entity.id,
                email = entity.email,
                username = entity.username,
                password = entity.password,
                token = entity.token
        )
    }
}
