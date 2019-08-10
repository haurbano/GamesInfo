package innovappte.mobile.domain.usecases

import innovappte.mobile.domain.models.Fixture
import io.reactivex.Single

interface GetFixturesUseCase {
    fun invoke(): Single<List<Fixture>>
}