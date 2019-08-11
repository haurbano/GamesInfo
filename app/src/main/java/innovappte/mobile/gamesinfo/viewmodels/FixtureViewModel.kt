package innovappte.mobile.gamesinfo.viewmodels

import innovappte.mobile.domain.models.*
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.adapters.ViewTypeValues
import java.time.LocalDateTime

open class FixtureViewModel(
    val awayTeam: AwayTeam,
    val competitionStage: CompetitionStage,
    val readableDate: String,
    val readableHour: String,
    val dayInNumber: String,
    val nameOfDay: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val type: String,
    val venue: Venue,
    val date: LocalDateTime
): ViewType {
    override fun getViewType() = ViewTypeValues.FIXTURE
}