package com.iulia.gardener.entity

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "app_user")
class AppUser (

        @Id
        @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(generator = "idGenerator")
        @Column
        var id: UUID,

        @Column
        var name: String?,

        @Column
        var email: String
): UuidEntity {
        override fun getUuid(): UUID {
                return id
        }
}
