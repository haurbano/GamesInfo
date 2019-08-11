package innovappte.mobile.gamesinfo.fixtures.mvp

import innovappte.mobile.domain.usecases.GetFixturesUseCase
import innovappte.mobile.gamesinfo.extensions.doInBackGround
import innovappte.mobile.gamesinfo.fixtures.FixturesFragmentContract
import innovappte.mobile.gamesinfo.mappers.FixtureVMMapper
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import io.reactivex.Single

class FixturesModel(
    private val getFixturesUseCase: GetFixturesUseCase,
    private val fixtureVMMapper: FixtureVMMapper
): FixturesFragmentContract.Model {

    override fun getFixtures(): Single<List<FixtureViewModel>> {
        return getFixturesUseCase()
            .map { it.sortedBy { fixture ->  fixture.getDate() } }
            .map{ fixtureVMMapper(it) }
            .doInBackGround()
    }
}