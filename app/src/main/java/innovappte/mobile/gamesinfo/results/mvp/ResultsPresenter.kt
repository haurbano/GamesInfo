package innovappte.mobile.gamesinfo.results.mvp

import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import io.reactivex.disposables.CompositeDisposable

class ResultsPresenter(
    private val model: ResultFragmentContrat.Model
): ResultFragmentContrat.Presenter {

    lateinit var view: ResultFragmentContrat.View
    private val disposables = CompositeDisposable()

    override fun attachView(view: ResultFragmentContrat.View) {
        this.view = view
    }

    override fun fillResults() {
        val disposable = model.getResults()
            .subscribe({ updateResultsInView(it) }, { showError(it) })

        disposables.add(disposable)
    }

    override fun filterByCompetition(competitionName: String) {
        val disposable = model.getResults()
            .map { applyCompetitionFilter(competitionName, it) }
            .subscribe({ updateResultsInView(it) }, { showError(it) })

        disposables.add(disposable)
    }

    private fun updateResultsInView(results: List<FixtureViewModel>) {
        val resultsWithDividers = model.addMonthsDividers(results)
        view.updateResults(resultsWithDividers)
    }

    private fun showError(error: Throwable) {
        view.showNetworkError()
    }

    private fun applyCompetitionFilter(competitionName: String, list: List<FixtureViewModel>): List<FixtureViewModel> {
        if (competitionName.isEmpty()) return list
        val competitionNameLowerCase = competitionName.toLowerCase()
        return list.filter { fixture ->
            fixture.competitionStage.competition.name.toLowerCase().startsWith(competitionNameLowerCase)
        }
    }
}