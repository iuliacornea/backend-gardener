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

        @Column(name = "app_user")
        var userId: UUID,

        @Column(name = "gardener")
        var gardenerId: UUID,

        @Column(name = "specimen")
        var specimenId: UUID?,

        /* raw value */
        @Column
        var airTemperatureRaw: Int,

        /* air temperature in Celsius degrees */
        @Column
        var airTemperatureCelsius: Int,

        /* raw value */
        @Column
        var airHumidityRaw: Int,

        /* air humidity in percentages where 100%=rain */
        @Column
        var airHumidityPercentage: Int,

        /* raw value is between 0 to 1023 */
        @Column
        var soilMoistureRaw: Int,

        /* computed from raw value where 100% = */
        @Column
        var soilMoisturePercentage: Int,

        /* raw value measured with the photoreceptor */
        @Column
        var lightIntensityRaw: Int,

        /* light intensity in lux computed from the photoreceptor value*/
        @Column
        var lightIntensityLux: Int,

        @Column
        var receivedAt: Timestamp
)
