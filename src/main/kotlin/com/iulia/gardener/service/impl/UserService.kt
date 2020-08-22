package com.iulia.gardener.service.impl

import com.iulia.gardener.entity.AppUser
import java.util.*

class UserService {

    companion object {
        private val user  = AppUser(
                                id = UUID.randomUUID(),
                                name = "Only user",
                                email = "only.user@iulia.com"
                            )

        fun getLoggedInUser() : AppUser {
            return user
        }
    }
}
