package create.queue.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.*

enum class ReportStatus {
    QUEUED,
    STARTED,
    FINISHED,
    ERROR
}

@Entity
@Table(name = "report")
class Report(
        @Id val uuid: UUID,
        @ManyToOne @JsonIgnoreProperties("reports") val site: Site,
        val dateFrom: Date,
        val dateTo: Date,
        @Column(name = "status") @Enumerated(EnumType.STRING) val status: ReportStatus
)
