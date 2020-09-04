package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.sql.Timestamp
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pot_gardener")
class GardenerEntity (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Column
        var name: String,

        @Column(name = "app_user")
        var appUserId: UUID,

        @Column
        var wifiNetwork: String,

        @Column
        var wifiPass: String,

        @Column
        var createdAt: Timestamp,

        @Column
        var orderId: UUID
)
