package innovappte.mobile.data.services

import innovappte.mobile.domain.models.Fixture
import io.reactivex.Single
import retrofit2.http.GET

interface FixtureService {
    @GET("fixtures.json")
    fun getFixtures(): Single<List<Fixture>>

    @GET("results.json")
    fun getResults(): Single<List<Fixture>>
}