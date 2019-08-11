package innovappte.mobile.gamesinfo.mappers

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateMapper {
    private fun getDate(stringDate: String): LocalDateTime {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        return  LocalDateTime.parse(stringDate, inputFormatter)
    }

    fun getReadableDate(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
        return outputFormatter.format(date)
    }

    fun getReadableHour(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm")
        return outputFormatter.format(date)
    }

    fun getDayInNumber(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("dd", Locale.ENGLISH)
        return outputFormatter.format(date)
    }

    fun getNameOfDay(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
        return outputFormatter.format(date)
    }
}