package innovappte.mobile.data.repositories

import innovappte.mobile.data.services.FixtureServiceProvider
import innovappte.mobile.domain.repositories.FixturesRepository

class FixturesRepositoryImpl(private val fixtureService: FixtureServiceProvider): FixturesRepository {

    override fun getFixtures() = fixtureService.get().getFixtures()

    override fun getResults() = fixtureService.get().getResults()

}