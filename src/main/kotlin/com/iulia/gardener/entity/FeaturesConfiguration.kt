package com.iulia.gardener.entity

import com.iulia.gardener.model.FlowerExistance
import com.iulia.gardener.model.FlowerPetals
import com.iulia.gardener.model.FlowerShape
import com.iulia.gardener.model.LeafArrangementOnTheStem
import com.iulia.gardener.model.LeafDivisionOfBlade
import com.iulia.gardener.model.LeafSurface
import com.iulia.gardener.model.LeafTexture
import com.iulia.gardener.model.LeafVeinType
import com.iulia.gardener.model.StemSpikes
import com.iulia.gardener.model.StemType
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
