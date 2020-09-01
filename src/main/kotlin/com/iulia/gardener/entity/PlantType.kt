package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "plant_type")
class PlantType (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Column
        var name: String,

        @Column
        var description: String?,

        @ManyToOne(optional = false)
        @JoinColumn(name = "features_configuration", nullable = false)
        var featuresConfiguration: FeaturesConfiguration,

        @ManyToOne(optional = false)
        @JoinColumn(name = "growing_configuration", nullable = false)
        var growingConfigurations: GrowingConfigurations,

        @Column
        var userUuid: UUID?,

        @Column
        var image: String?
): UuidEntity {
        override fun getUuid(): UUID {
                return id!!
        }
}
