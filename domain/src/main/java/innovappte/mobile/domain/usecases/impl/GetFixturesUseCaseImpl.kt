package innovappte.mobile.domain.usecases.impl

import innovappte.mobile.domain.repositories.FixturesRepository
import innovappte.mobile.domain.usecases.GetFixturesUseCase

class GetFixturesUseCaseImpl(private val fixturesRepository: FixturesRepository): GetFixturesUseCase {
    override operator fun invoke() = fixturesRepository.getFixtures()
}