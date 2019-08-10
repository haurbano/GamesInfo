package innovappte.mobile.gamesinfo.mainscreen.mvp

import innovappte.mobile.gamesinfo.mainscreen.MainActivityContract

class MainPresenter:  MainActivityContract.Presenter {
    private lateinit var view: MainActivityContract.View

    override fun fillFragments() {
        view.fillFragments()
    }

    override fun attachView(view: MainActivityContract.View) {
        this.view = view
    }
}