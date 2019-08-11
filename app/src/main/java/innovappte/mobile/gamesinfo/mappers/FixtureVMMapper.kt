package innovappte.mobile.gamesinfo.mappers

import innovappte.mobile.domain.models.Fixture
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class FixtureVMMapper(private val dateMapper: DateMapper) {
    private fun transform(fixture: Fixture): FixtureViewModel {
        return FixtureViewModel(
            awayTeam = fixture.awayTeam,
            competitionStage = fixture.competitionStage,
            readableDate = dateMapper.getReadableDate(fixture.date),
            readableHour = dateMapper.getReadableHour(fixture.date),
            dayInNumber = dateMapper.getDayInNumber(fixture.date),
            nameOfDay = dateMapper.getNameOfDay(fixture.date),
            homeTeam = fixture.homeTeam,
            id = fixture.id,
            type = fixture.type,
            venue = fixture.venue,
            date = dateMapper.getDate(fixture.date)
        )
    }

    operator fun invoke(fixtures: List<Fixture>): List<FixtureViewModel> {
        return fixtures.map(::transform)
    }
}