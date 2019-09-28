package create.queue.domain

import javax.persistence.*

@Entity
@Table(name = "site")
class Site (
        @Id val id: Long,
        @Column(name = "name") val name: String,
        @OneToMany(mappedBy = "site", fetch = FetchType.EAGER) val reports: Set<Report>,
        @OneToMany(mappedBy = "site", fetch = FetchType.EAGER) val siteSensors: Set<SiteSensor>

)
