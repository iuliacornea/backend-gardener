package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.sql.Timestamp
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "pot_gardener")
class Gardener (

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

        @Column(name = "wifi_pass")
        var wifiPassword: String,

        @Column
        var createdAt: Timestamp?,

        @OneToOne(optional = false)
        @JoinColumn(
                name = "order_id", nullable = false, updatable = false)
        var order: GardenerOrder
)
