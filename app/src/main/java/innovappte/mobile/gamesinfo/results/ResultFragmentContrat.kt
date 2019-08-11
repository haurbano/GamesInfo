package innovappte.mobile.gamesinfo.results

import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single

interface ResultFragmentContrat {
    interface View {
        fun updateResults(results: List<ResultViewModel>)
        fun showNetworkError()
    }

    interface Presenter {
        fun fillResults()
        fun attachView(view: View)
    }

    interface Model {
        fun getResults(): Single<List<ResultViewModel>>
    }
}