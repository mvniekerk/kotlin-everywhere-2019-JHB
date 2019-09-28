package create.queue.domain

import javax.persistence.*

enum class BatteryStatus {
    New, High, Low, LowLow, Unknown
}

enum class DetectionMode {
    FootstepsAndVehicle, Vehicle, Footsteps, Activity, Unknown
}

@Entity
@Table(name = "status_tag_event")
class StatusTagEvent (
    @Id val id: Long,
    @Column(name = "tag_id") val tagId: String,
    @Column(name = "ts") val ts: Long,
    @Column(name = "battery") @Enumerated(EnumType.STRING) val battery: BatteryStatus,
    @Column(name = "detectionMode") @Enumerated(EnumType.STRING) val detectionMode: DetectionMode,
    @Column(name = "shuttingDown") val shuttingDown: Boolean,
    @OneToOne(mappedBy = "status") val tagEvent: TagEvent
)
