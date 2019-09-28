package create.queue.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "site_sensor")
class SiteSensor (
        @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
        @SequenceGenerator(name = "sequenceGenerator") val id: Long,
        @Column(name = "name") val name: String,
        @ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("sensors") val sensor: Sensor,
        @ManyToOne(fetch = FetchType.EAGER) @JsonIgnoreProperties("sites") val site: Site
)
