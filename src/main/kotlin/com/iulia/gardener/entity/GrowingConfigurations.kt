package com.iulia.gardener.entity

import com.iulia.gardener.model.SoilType
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
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
        var id: UUID,

        @Column
        var soilType: SoilType?,

        @Column
        var soilQuantity: Float?,

        @Column
        var soilHumiditySummer: Int?,

        @Column
        var soilHumidityWinter: Int?,

        @Column
        var airHumidity: Int?,

        @Column
        var airTemperatureSummer: Float?,

        @Column
        var airTemperatureWinter: Float?,

        @Column
        var lightIntensitySummer: Float?,

        @Column
        var lightIntensityWinter: Float?
): UuidEntity {
        override fun getUuid(): UUID {
                return id
        }
}
