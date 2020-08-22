package com.iulia.gardener.entity

import org.openapitools.gardener.model.Season
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
@Table(name = "specimen")
class Specimen (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Column(name = "app_user")
        var appUserId: UUID,

        @Column
        var name: String,

        @ManyToOne(optional = true)
        @JoinColumn(name = "plant_type", nullable = true)
        var plantType: PlantType?,

        @ManyToOne(optional = true)
        @JoinColumn(name = "growing_configuration", nullable = true)
        var growingConfigurations: GrowingConfigurations?,

        @Column
        var season: Season?
): UuidEntity {
        override fun getUuid(): UUID {
                return id!!
        }
}
