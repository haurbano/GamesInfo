package innovappte.mobile.gamesinfo.fixtures.mvp

import android.util.Log
import innovappte.mobile.gamesinfo.fixtures.FixturesFragmentContract
import io.reactivex.disposables.CompositeDisposable

class FixturesPresenter(
    private val model: FixturesFragmentContract.Model
): FixturesFragmentContract.Presenter {

    private val disposables = CompositeDisposable()

    lateinit var view: FixturesFragmentContract.View

    override fun fillFixtures() {
        val disposable = model.getFixtures()
            .doOnError{ error -> Log.e("--haur", error.localizedMessage) }
            .subscribe(
            { fixtures -> view.updateFixtures(fixtures)},
            { view.showErroGettingFixtures()}
        )
        disposables.add(disposable)
    }

    override fun attachView(view: FixturesFragmentContract.View) {
        this.view = view
    }
}