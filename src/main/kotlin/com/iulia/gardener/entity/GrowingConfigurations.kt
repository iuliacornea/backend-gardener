package com.iulia.gardener.entity

import org.openapitools.gardener.model.FiveDegreeScale
import org.openapitools.gardener.model.SoilType
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "growing_configuration")
class GrowingConfigurations (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Column
        var name: String,

        @Enumerated(EnumType.STRING)
        @Column
        var soilType: SoilType?,

        /* Soil humidity in percentage 100% = water, 30% = dry soil*/
        @Column
        var soilHumiditySummer: Int?,

        /* Soil humidity in percentage 100% = water, 30% = dry soil*/
        @Column
        var soilHumidityWinter: Int?,

        /* Air humidity in percentage 100% = rain*/
        @Column
        var airHumidity: Int?,

        /* Air temperature in Celsius degrees*/
        @Column
        var airTemperatureSummer: Int?,

        /* Air temperature in Celsius degrees*/
        @Column
        var airTemperatureWinter: Int?,

        /* Light intensity in LUX*/
        @Column
        var lightIntensity: Int?,

        @Column
        var wateringIntervalDays: Int?,

        /* User who created this config or null in case it's a global config created by an admin*/
        @Column(name = "app_user")
        var appUserId: UUID?
): UuidEntity {
        override fun getUuid(): UUID {
                return id!!
        }
}
