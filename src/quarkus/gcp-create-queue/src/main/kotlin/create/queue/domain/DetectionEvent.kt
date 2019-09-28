package create.queue.domain

import javax.persistence.*

@Entity
@Table(name = "detection_tag_event")
class DetectionEvent (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id") val id: Long,
    @Column(name = "tag_id") val tagId: Int,
    @Column(name = "jhi_timestamp") val timestamp: Long,
    @Column(name = "tamper") val tamper: Boolean,
    @Column(name = "persistance") val persistance: Boolean,
    @Column(name = "footsteps") val footsteps: Boolean,
    @Column(name = "vehicle") val vehicle: Boolean,
    @Column(name = "activity") val activity: Boolean,
    @OneToOne(mappedBy = "detection") val tagEvent: TagEvent
)
