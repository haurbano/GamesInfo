package innovappte.mobile.gamesinfo.fixtures.mvp

import innovappte.mobile.domain.usecases.GetFixturesUseCase
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.extensions.doInBackGround
import innovappte.mobile.gamesinfo.fixtures.FixturesFragmentContract
import innovappte.mobile.gamesinfo.mappers.FixtureVMMapper
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import innovappte.mobile.gamesinfo.viewmodels.MonthDividerViewModel
import io.reactivex.Single
import java.text.DateFormatSymbols

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

    override fun addMonthsDividers(fixtures: List<FixtureViewModel>): List<ViewType> {
        val newList = ArrayList<ViewType>()
        fixtures.groupBy { it.date.monthValue }
            .forEach { map ->
                newList.add(MonthDividerViewModel(getMonthWith(map.key)))
                newList.addAll(map.value)
            }

        return newList
    }

    private fun getMonthWith(monthValue: Int): String {
        return DateFormatSymbols().months[monthValue - 1]
    }
}