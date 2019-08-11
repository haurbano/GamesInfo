package innovappte.mobile.domain.models

data class CompetitionStage(
    val competition: Competition
) {
    data class Competition(
        val id: Int,
        val name: String
    )
}