package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "greenhouse_stats")
class GreenhouseStats(
        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Column
        var userEmail: String,

        @Column
        var airTemperature: Int,

        @Column
        var airHumidity: Int,

        @Column
        var soilMoidture: Int,

        @Column
        var photoresistance: Int
) {}
