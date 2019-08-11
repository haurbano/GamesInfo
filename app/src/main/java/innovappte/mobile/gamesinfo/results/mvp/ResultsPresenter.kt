package innovappte.mobile.gamesinfo.results.mvp

import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import io.reactivex.disposables.CompositeDisposable

class ResultsPresenter(
    private val model: ResultFragmentContrat.Model
): ResultFragmentContrat.Presenter {

    lateinit var view: ResultFragmentContrat.View
    private val disposables = CompositeDisposable()
    private val completeList = ArrayList<FixtureViewModel>()

    override fun attachView(view: ResultFragmentContrat.View) {
        this.view = view
    }

    override fun fillResults() {
        val disposable = model.getResults()
            .subscribe(
                { results ->
                    updateResultsToFilter(results)
                    updateResultsInView(results)
                },
                { view.showNetworkError() }
            )
        disposables.add(disposable)
    }

    override fun filterByCompetition(competitionName: String) {
        if (competitionName.isNotEmpty()) {
            val competitionNameLowerCase = competitionName.toLowerCase()
            val filteredList = completeList.filter {
                it.competitionStage.competition.name.toLowerCase().startsWith(competitionNameLowerCase)
            }
            updateResultsInView(filteredList)
        } else {
            updateResultsInView(completeList)
        }
    }

    private fun updateResultsInView(results: List<FixtureViewModel>) {
        val resultsWithDividers = model.addMonthsDividers(results)
        view.updateResults(resultsWithDividers)
    }

    private fun updateResultsToFilter(results: List<FixtureViewModel>) {
        completeList.apply {
            clear()
            addAll(results)
        }
    }
}