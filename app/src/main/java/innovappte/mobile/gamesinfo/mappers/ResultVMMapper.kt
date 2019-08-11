package innovappte.mobile.gamesinfo.mappers

import innovappte.mobile.domain.models.Fixture
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel

class ResultVMMapper(private val dateMapper: DateMapper) {
    private fun transform(fixture: Fixture): ResultViewModel {
        return ResultViewModel(
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
            score = fixture.score,
            date = dateMapper.getDate(fixture.date)
        )
    }

    operator fun invoke(fixtures: List<Fixture>): List<ResultViewModel> {
        return fixtures.map(::transform)
    }
}