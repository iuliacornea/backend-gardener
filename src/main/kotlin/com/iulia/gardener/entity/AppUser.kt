package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.net.PasswordAuthentication
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Entity
@Table(name = "app_user")
class AppUser (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID?,

        @Column
        var email: String,

        @Column
        var username: String?,

        @Size(message = "Password must be at least 6 characters", min = 6)
        @Column
        var password: String,

        @Column
        var token: String?

): UuidEntity {
        override fun getUuid(): UUID {
                return id!!
        }
}
