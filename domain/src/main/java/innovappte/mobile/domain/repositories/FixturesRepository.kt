package innovappte.mobile.domain.repositories

import innovappte.mobile.domain.models.Fixture
import io.reactivex.Single

interface FixturesRepository {
    fun getFixtures(): Single<List<Fixture>>
    fun getResults(): Single<List<Fixture>>
}