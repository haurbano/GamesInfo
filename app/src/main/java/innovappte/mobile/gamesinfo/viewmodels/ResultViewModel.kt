package innovappte.mobile.gamesinfo.viewmodels

import innovappte.mobile.domain.models.*
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.adapters.ViewTypeValues

class ResultViewModel(
    awayTeam: AwayTeam,
    competitionStage: CompetitionStage,
    readableDate: String,
    readableHour: String,
    dayInNumber: String,
    nameOfDay: String,
    homeTeam: HomeTeam,
    id: Int,
    type: String,
    venue: Venue,
    val score: Score?
): FixtureViewModel(
    awayTeam,
    competitionStage,
    readableDate,
    readableHour,
    dayInNumber,
    nameOfDay,
    homeTeam,
    id,
    type,
    venue
), ViewType {
    override fun getViewType() = ViewTypeValues.RESULT
}