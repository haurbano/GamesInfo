package innovappte.mobile.gamesinfo.results.mvp

import innovappte.mobile.domain.usecases.GetResultsUseCase
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.extensions.doInBackGround
import innovappte.mobile.gamesinfo.mappers.ResultVMMapper
import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import innovappte.mobile.gamesinfo.viewmodels.MonthDividerViewModel
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single
import java.text.DateFormatSymbols

class ResultsModel(
    private val getResultsUseCase: GetResultsUseCase,
    private val resultVMMapper: ResultVMMapper
): ResultFragmentContrat.Model {

    override fun getResults(): Single<List<ResultViewModel>> {
        return getResultsUseCase()
            .map { it.sortedBy { fixture ->  fixture.getDate() } }
            .map { resultVMMapper(it) }
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