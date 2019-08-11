package innovappte.mobile.gamesinfo.fixtures

import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import io.reactivex.Single

interface FixturesFragmentContract {
    interface View {
        fun updateFixtures(fixtures: List<FixtureViewModel>)
        fun showErrorGettingFixtures()
    }

    interface Presenter {
        fun fillFixtures()
        fun attachView(view: View)
    }

    interface Model {
        fun getFixtures(): Single<List<FixtureViewModel>>
    }
}