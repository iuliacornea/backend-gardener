package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import org.openapitools.gardener.model.OrderStatus
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
@Table(name = "gardener_order")
class GardenerOrder (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Column(name = "app_user")
        var appUserId: UUID,

        @Column
        var gardenerName: String,

        @Column
        var wifiNetwork: String,

        @Column(name = "wifi_pass")
        var wifiPassword: String,

        @Enumerated(EnumType.STRING)
        @Column
        var status: OrderStatus,

        @Column
        var createdAt: Timestamp,

        @Column
        var lastUpdate: Timestamp?
)
