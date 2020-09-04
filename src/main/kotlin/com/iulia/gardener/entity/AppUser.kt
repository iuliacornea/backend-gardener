package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import org.openapitools.gardener.model.UserRole
import java.net.PasswordAuthentication
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Entity
@Table(name = "app_user")
class AppUser(

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Column
        var email: String,

        @Column
        var username: String,

        @Size(message = "Password must be at least 6 characters", min = 6)
        @Column
        var password: String,

        @Enumerated(EnumType.STRING)
        @Column
        var role: UserRole,

        @Column
        var token: String?

)
