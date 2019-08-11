package innovappte.mobile.domain.models

data class Fixture(
    val awayTeam: AwayTeam,
    val competitionStage: CompetitionStage,
    val date: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val score: Score?,
//    val state: String,
    val type: String,
    val venue: Venue
)