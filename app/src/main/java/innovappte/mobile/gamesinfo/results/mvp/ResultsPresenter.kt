package innovappte.mobile.gamesinfo.results.mvp

import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import io.reactivex.disposables.CompositeDisposable

class ResultsPresenter(
    private val model: ResultFragmentContrat.Model
): ResultFragmentContrat.Presenter {
    lateinit var view: ResultFragmentContrat.View

    private val disposables = CompositeDisposable()

    override fun fillResults() {
        val disposable = model.getResults()
            .subscribe(
                { results -> view.updateResults(results) },
                { view.showNetworkError() }
            )
        disposables.add(disposable)
    }

    override fun attachView(view: ResultFragmentContrat.View) {
        this.view = view
    }
}