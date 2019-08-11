package innovappte.mobile.gamesinfo.mappers

import innovappte.mobile.domain.models.Fixture
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class FixtureVMMapper {
    private fun transform(fixture: Fixture): FixtureViewModel {
        return FixtureViewModel(
            awayTeam = fixture.awayTeam,
            competitionStage = fixture.competitionStage,
            readableDate = getReadableDate(fixture.date),
            readableHour = getReadableHour(fixture.date),
            dayInNumber = getDayInNumber(fixture.date),
            nameOfDay = getNameOfDay(fixture.date),
            homeTeam = fixture.homeTeam,
            id = fixture.id,
            score = fixture.score,
            type = fixture.type,
            venue = fixture.venue
        )
    }

    operator fun invoke(fixtures: List<Fixture>): List<FixtureViewModel> {
        return fixtures.map(::transform)
    }

    private fun getDate(stringDate: String): LocalDateTime {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        return  LocalDateTime.parse(stringDate, inputFormatter)
    }

    private fun getReadableDate(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
        return outputFormatter.format(date)
    }

    private fun getReadableHour(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm")
        return outputFormatter.format(date)
    }

    private fun getDayInNumber(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("dd", Locale.ENGLISH)
        return outputFormatter.format(date)
    }

    private fun getNameOfDay(stringDate: String): String {
        val date = getDate(stringDate)
        val outputFormatter = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH)
        return outputFormatter.format(date)
    }

}