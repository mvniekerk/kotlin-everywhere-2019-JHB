package create.queue

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class DummyEntity(
        @Id val id: Long
)
