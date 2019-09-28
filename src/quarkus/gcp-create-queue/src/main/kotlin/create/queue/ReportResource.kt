package create.queue

import create.queue.domain.Report
import create.queue.domain.ReportStatus
import create.queue.services.ReportService
import create.queue.services.SiteService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import java.util.*
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ParamConverter

@Path("/report")
class ReportResource(
        private val dateParamConverter: ParamConverter<Date>,
        private val siteService: SiteService,
        private val reportService: ReportService
) {

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST @Path("/{siteId}/{dateFrom}/{dateTo}")
    fun createReport(
            @PathParam("siteId") siteId: Long,
            @PathParam("dateFrom") dateFromVal: String,
            @PathParam("dateTo") dateToVal: String): Response {
        val site = siteService.findById(siteId) ?: throw NotFoundException()
        val dateFrom = dateParamConverter.fromString(dateFromVal)
        val dateTo = dateParamConverter.fromString(dateToVal)
        val report = reportService.findBySiteAndDateFromAndDateTo(site, dateFrom, dateTo)

        if (report != null) {
            return Response.status(Response.Status.CONFLICT)
                    .entity(report)
                    .build()
        }

        val ret = reportService.save(Report(
                uuid = UUID.randomUUID(),
                site = siteService.merge(site),
                dateFrom = dateFrom,
                dateTo = dateTo,
                status = ReportStatus.QUEUED
        ))
        return Response.ok(ret).status(Response.Status.CREATED).build()
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @GET @Path("/{siteId}/{dateFrom}/{dateTo}")
    fun getReport(
            @PathParam("siteId") siteId: Long,
            @PathParam("dateFrom") dateFromVal: String,
            @PathParam("dateTo") dateToVal: String): Response {
        val site = siteService.findById(siteId) ?: throw NotFoundException()
        val dateFrom = dateParamConverter.fromString(dateFromVal)
        val dateTo = dateParamConverter.fromString(dateToVal)
        val report = reportService.findBySiteAndDateFromAndDateTo(site, dateFrom, dateTo)

        return report?.let {
            Response.ok(it)
                    .build()
        } ?: Response.status(Response.Status.NOT_FOUND).build()
    }
}
