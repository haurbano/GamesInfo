package innovappte.mobile.domain.models

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class Fixture(
    val awayTeam: AwayTeam,
    val competitionStage: CompetitionStage,
    val date: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val score: Score?,
    val type: String,
    val venue: Venue
) {
    fun getDate(): LocalDateTime {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        return  LocalDateTime.parse(date, inputFormatter)
    }
}