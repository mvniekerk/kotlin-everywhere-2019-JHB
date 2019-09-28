package create.queue.services

import create.queue.domain.Site
import javax.enterprise.context.RequestScoped
import javax.persistence.EntityManager
import javax.transaction.Transactional

@RequestScoped
class SiteService(
        open val entityManager: EntityManager
) {

    fun findById(id: Long): Site? {
        return entityManager.find(Site::class.java, id)
    }

    @Transactional
    fun merge(site: Site): Site = entityManager.merge(site)
}
