package create.queue

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton
import javax.ws.rs.BadRequestException
import javax.ws.rs.ext.ParamConverter

@Singleton
class DateParamConverter : ParamConverter<Date> {
    override fun fromString(param: String): Date {
        try {
            return SimpleDateFormat(DATE_PATTERN).parse(param.trim { it <= ' ' })
        } catch (e: ParseException) {
            throw BadRequestException(e)
        }
    }

    override fun toString(date: Date): String {
        return SimpleDateFormat(DATE_PATTERN).format(date)
    }

    companion object {
        val DATE_PATTERN = "yyyy-MM-dd"
    }
}
