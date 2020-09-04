package com.iulia.gardener.entity

import org.openapitools.gardener.model.FlowerExistance
import org.openapitools.gardener.model.FlowerShape
import org.openapitools.gardener.model.LeafArrangementOnTheStem
import org.openapitools.gardener.model.LeafDivisionOfBlade
import org.openapitools.gardener.model.LeafSurface
import org.openapitools.gardener.model.LeafTexture
import org.openapitools.gardener.model.LeafVeinType
import org.openapitools.gardener.model.StemSpikes
import org.openapitools.gardener.model.StemType
import org.hibernate.annotations.GenericGenerator
import org.openapitools.gardener.model.FlowerPetals
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "features_configuration")
class FeaturesConfiguration (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID? = null,

        @Enumerated(EnumType.STRING)
        @Column
        var stemType: StemType?,

        @Enumerated(EnumType.STRING)
        @Column
        var stemSpikes: StemSpikes?,

        @Enumerated(EnumType.STRING)
        @Column
        var leafDivisionOfBlade: LeafDivisionOfBlade?,

        @Enumerated(EnumType.STRING)
        @Column
        var leafArrangementOnTheStem: LeafArrangementOnTheStem?,

        @Enumerated(EnumType.STRING)
        @Column
        var leafSurface: LeafSurface?,

        @Enumerated(EnumType.STRING)
        @Column
        var leafTexture: LeafTexture?,

        @Enumerated(EnumType.STRING)
        @Column
        var leafVeinType: LeafVeinType?,

        @Enumerated(EnumType.STRING)
        @Column
        var flowerExistance: FlowerExistance?,

        @Enumerated(EnumType.STRING)
        @Column
        var flowerShape: FlowerShape?,

        @Enumerated(EnumType.STRING)
        @Column
        var flowerPetals: FlowerPetals?
): UuidEntity {
        override fun getUuid(): UUID {
                return id!!
        }
}
