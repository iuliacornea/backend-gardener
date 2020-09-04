package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.sql.Timestamp
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
        var gardener: UUID,

        @Column
        var specimen: UUID,

        @Column
        var airTemperatureRaw: Int,

        @Column
        var airHumidityRaw: Int,

        @Column
        var soilMoidtureRaw: Int,

        @Column
        var soilMoidturePercentage: Int,

        @Column
        var photoresistanceRaw: Int,

        @Column
        var photoresistanceLux: Int,

        @Column
        var receivedAt: Timestamp
)
