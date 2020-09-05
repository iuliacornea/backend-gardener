package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
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

        @ManyToOne(optional = true)
        @JoinColumn(name = "features_configuration", nullable = true)
        var featuresConfiguration: FeaturesConfiguration?,

        @ManyToOne(optional = true)
        @JoinColumn(name = "growing_configuration", nullable = true)
        var growingConfiguration: GrowingConfiguration?,

        @Column(name = "app_user")
        var appUserId: UUID?,

        @Column
        var image: String?
): UuidEntity {
        override fun getUuid(): UUID {
                return id!!
        }
}
