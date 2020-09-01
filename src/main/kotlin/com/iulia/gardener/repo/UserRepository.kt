package com.iulia.gardener.repo

import com.iulia.gardener.entity.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<AppUser, UUID> {

    fun existsByEmail(email: String): Boolean

    fun findByEmailAndPassword(email: String, password: String): AppUser

    fun getById(id: UUID): AppUser

    fun findByToken(token: String): AppUser

}
