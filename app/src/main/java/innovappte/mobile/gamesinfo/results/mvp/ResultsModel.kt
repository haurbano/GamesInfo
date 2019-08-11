package innovappte.mobile.gamesinfo.results.mvp

import innovappte.mobile.domain.usecases.GetResultsUseCase
import innovappte.mobile.gamesinfo.mappers.ResultVMMapper
import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ResultsModel(
    private val getResultsUseCase: GetResultsUseCase,
    private val resultVMMapper: ResultVMMapper
): ResultFragmentContrat.Model {
    override fun getResults(): Single<List<ResultViewModel>> {
        return getResultsUseCase().map { resultVMMapper(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}