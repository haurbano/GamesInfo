package innovappte.mobile.domain.usecases

import innovappte.mobile.domain.models.Fixture
import io.reactivex.Single

interface GetResultsUseCase {
    fun invoke(): Single<List<Fixture>>
}