package create.queue.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant
import javax.persistence.*

enum class TagEventType {
    Detection, Status
}

@Entity
@Table(name = "tag_event")
class TagEvent (
        @Id val id: Long,
        @Enumerated(EnumType.STRING) @Column(name = "event_type") val eventType: TagEventType,
        @Column(name = "jhi_when") val ts: Instant? = null,
        @OneToOne(fetch = FetchType.EAGER) @JoinColumn(unique = true) val detection: DetectionEvent? = null,
        @OneToOne(fetch = FetchType.EAGER) @JoinColumn(unique = true) val status: StatusTagEvent? = null,
        @ManyToOne @JsonIgnoreProperties("tagEvents") val sensor: Sensor
)
