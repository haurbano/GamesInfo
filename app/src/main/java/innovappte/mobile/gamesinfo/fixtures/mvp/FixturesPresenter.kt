package innovappte.mobile.gamesinfo.fixtures.mvp

import innovappte.mobile.gamesinfo.fixtures.FixturesFragmentContract
import io.reactivex.disposables.CompositeDisposable

class FixturesPresenter(
    private val model: FixturesFragmentContract.Model
): FixturesFragmentContract.Presenter {

    private val disposables = CompositeDisposable()

    lateinit var view: FixturesFragmentContract.View

    override fun fillFixtures() {
        val disposable = model.getFixtures()
            .map { model.addMonthsDividers(it) }
            .subscribe(
            { fixtures -> view.updateFixtures(fixtures)},
            { view.showErrorGettingFixtures()}
        )
        disposables.add(disposable)
    }

    override fun attachView(view: FixturesFragmentContract.View) {
        this.view = view
    }
}