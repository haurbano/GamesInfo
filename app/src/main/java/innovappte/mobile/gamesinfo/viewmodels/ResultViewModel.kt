package innovappte.mobile.gamesinfo.viewmodels

import innovappte.mobile.domain.models.*
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.adapters.ViewTypeValues
import java.time.LocalDateTime

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
    val score: Score?,
    date: LocalDateTime
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
    venue,
    date
), ViewType {
    override fun getViewType() = ViewTypeValues.RESULT
}