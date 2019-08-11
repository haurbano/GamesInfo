package innovappte.mobile.gamesinfo.results

import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single

interface ResultFragmentContrat {
    interface View {
        fun updateResults(results: List<ViewType>)
        fun showNetworkError()
    }

    interface Presenter {
        fun fillResults()
        fun attachView(view: View)
    }

    interface Model {
        fun getResults(): Single<List<ResultViewModel>>
        fun addMonthsDividers(fixtures: List<FixtureViewModel>): List<ViewType>
    }
}