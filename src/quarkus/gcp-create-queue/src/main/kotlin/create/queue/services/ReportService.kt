package create.queue.services

import create.queue.domain.Report
import create.queue.domain.Site
import java.util.*
import javax.enterprise.context.RequestScoped
import javax.persistence.EntityManager
import javax.transaction.Transactional

@RequestScoped
class ReportService(
        open val entityManager: EntityManager
) {

    fun findBySiteAndDateFromAndDateTo(
            site: Site, dateFrom: Date, dateTo: Date
    ): Report? {
        val builder = entityManager.criteriaBuilder
        val query = builder.createQuery(Report::class.java)
        val root = query.from(Report::class.java)

        val eqSite = builder.equal(root.get<Site>("site"), site)
        val eqDateFrom = builder.equal(root.get<Date>("dateFrom"), dateFrom)
        val eqDateTo = builder.equal(root.get<Date>("dateTo"), dateTo)
        val qb = query.select(root).where(builder.and(eqSite, eqDateFrom, eqDateTo))
        return entityManager.createQuery(qb).resultStream.findFirst().orElse(null)
    }

    @Transactional
    fun save(report: Report): Report = entityManager.persist(report).run { return report }
}
