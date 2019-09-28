package create.queue.domain

import javax.persistence.*

@Entity
@Table(name = "sensor")
class Sensor (
        @Id val id: Long,
        @Column(name = "tag_id") val tagId: Int,
        @OneToMany(mappedBy = "sensor") val siteSensors: Set<SiteSensor>,
        @OneToMany(mappedBy = "sensor") val hourStats: Set<HourStats>,
        @OneToMany(mappedBy = "sensor") val tagEvents: Set<TagEvent>
)
