package com.iulia.gardener.entity

import org.openapitools.gardener.model.Season
import org.hibernate.annotations.GenericGenerator
import java.sql.Timestamp
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "specimen")
class Specimen(

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @ManyToOne(optional = true)
        @JoinColumn(name = "plant_type", nullable = true)
        var plantType: PlantType?,

        @ManyToOne(optional = true)
        @JoinColumn(name = "growing_configuration", nullable = true)
        var growingConfiguration: GrowingConfiguration?,

        @Column(name = "app_user")
        var appUserId: UUID,

        @Column
        var name: String,

        @Enumerated(EnumType.STRING)
        @Column
        var season: Season?,

        @Column
        var createdAt: Timestamp?,

        @OneToOne(optional = true)
        @JoinColumn(
                name = "gardener", nullable = true, updatable = false, insertable = true)
        var gardener: Gardener?
) : UuidEntity {
    override fun getUuid(): UUID {
        return id!!
    }
}
