package innovappte.mobile.gamesinfo.di

import innovappte.mobile.gamesinfo.mainscreen.MainActivityContract
import innovappte.mobile.gamesinfo.mainscreen.mvp.MainPresenter
import org.koin.dsl.module

val appModule = module {
    factory <MainActivityContract.Presenter>{ MainPresenter() }
}