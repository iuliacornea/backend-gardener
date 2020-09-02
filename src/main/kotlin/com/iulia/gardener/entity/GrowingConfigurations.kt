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

        @Enumerated(EnumType.STRING)
        @Column
        var soilType: SoilType?,

        @Column
        var soilQuantity: Int?,

        @Enumerated(EnumType.STRING)
        @Column
        var soilHumiditySummer: FiveDegreeScale?,

        @Enumerated(EnumType.STRING)
        @Column
        var soilHumidityWinter: FiveDegreeScale?,

        @Enumerated(EnumType.STRING)
        @Column
        var airHumidity: FiveDegreeScale?,

        @Column
        var airTemperatureSummer: Int?,

        @Column
        var airTemperatureWinter: Int?,

        @Enumerated(EnumType.STRING)
        @Column
        var lightIntensitySummer: FiveDegreeScale?,

        @Enumerated(EnumType.STRING)
        @Column
        var lightIntensityWinter: FiveDegreeScale?,

        @Column(name = "app_user")
        var appUserId: UUID?
): UuidEntity {
        override fun getUuid(): UUID {
                return id!!
        }
}
