package innovappte.mobile.gamesinfo.mappers

import innovappte.mobile.domain.models.Fixture
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel

class FixtureVMMapper {
    private fun transform(fixture: Fixture): FixtureViewModel {
        return FixtureViewModel(
            awayTeam = fixture.awayTeam,
            competitionStage = fixture.competitionStage,
            readableDate = "Test Date",
            readableHour = "Test Hour",
            homeTeam = fixture.homeTeam,
            id = fixture.id,
            score = fixture.score,
//            state = fixture.state,
            type = fixture.type,
            venue = fixture.venue
        )
    }

    operator fun invoke(fixtures: List<Fixture>): List<FixtureViewModel> {
        return fixtures.map(::transform)
    }

}