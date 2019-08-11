package innovappte.mobile.gamesinfo.results.mvp

import innovappte.mobile.domain.usecases.GetResultsUseCase
import innovappte.mobile.gamesinfo.extensions.doInBackGround
import innovappte.mobile.gamesinfo.mappers.ResultVMMapper
import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single

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
}