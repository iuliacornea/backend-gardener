package com.iulia.gardener.repo

import com.iulia.gardener.entity.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AppUserRepository: JpaRepository<AppUser, UUID> {
}
