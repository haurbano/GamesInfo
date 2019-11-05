package innovappte.mobile.gamesinfo

import innovappte.mobile.domain.models.*
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import java.time.LocalDateTime

object MockModels {
    fun getResultViewModel(): ResultViewModel {
        return ResultViewModel(
            awayTeam = getAwayTeam(),
            competitionStage = getCompetitionStage(),
            readableDate = "",
            readableHour = "",
            dayInNumber = "",
            nameOfDay =  "",
            homeTeam = getHomeTeam(),
            id = 0,
            type = "",
            venue = getVenue(),
            score = getScore(),
            date = LocalDateTime.now()
        )
    }

    fun getAwayTeam() = AwayTeam(
        abbr = "abbr",
        alias = "alias",
        name = "team",
        id = 0,
        shortName = "shortName"
    )

    fun getCompetitionStage() = CompetitionStage(
        competition = CompetitionStage.Competition(1, "Premier League")
    )

    fun getHomeTeam() = HomeTeam("", "", 0, "", "")

    fun getVenue() = Venue(0, "")

    fun getScore() = Score(0, 1, "")
}