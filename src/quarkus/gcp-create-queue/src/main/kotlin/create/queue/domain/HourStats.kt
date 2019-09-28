package create.queue.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
class HourStats (
        @Id val id: UUID,
        @ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("hourStats") val sensor: Sensor,
        @Column(name = "time_from") val timeFrom: Instant,
        @Column(name = "time_to") val timeTo: Instant,
        @Column(name = "events") val events: Int,
        @Column(name = "detection") val detectionCount: Int,
        @Column(name = "status") val statusCount: Int,
        @Column(name = "footsteps") val footstepsCount: Int,
        @Column(name = "vehicle") val vehicleCount: Int,
        @Column(name = "activity") val activityCount: Int,
        @Column(name = "mode") @Enumerated(EnumType.STRING) val detectionMode: DetectionMode
)
