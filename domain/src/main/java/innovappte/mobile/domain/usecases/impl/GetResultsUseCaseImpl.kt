package innovappte.mobile.domain.usecases.impl

import innovappte.mobile.domain.repositories.FixturesRepository
import innovappte.mobile.domain.usecases.GetResultsUseCase

class GetResultsUseCaseImpl(private val fixturesRepository: FixturesRepository): GetResultsUseCase {
    override operator fun invoke() = fixturesRepository.getResults()
}