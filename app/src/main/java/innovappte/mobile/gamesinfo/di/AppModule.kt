package innovappte.mobile.gamesinfo.di

import innovappte.mobile.domain.usecases.GetFixturesUseCase
import innovappte.mobile.domain.usecases.impl.GetFixturesUseCaseImpl
import innovappte.mobile.gamesinfo.fixtures.FixturesFragmentContract
import innovappte.mobile.gamesinfo.fixtures.mvp.FixturesModel
import innovappte.mobile.gamesinfo.fixtures.mvp.FixturesPresenter
import innovappte.mobile.gamesinfo.mainscreen.MainActivityContract
import innovappte.mobile.gamesinfo.mainscreen.mvp.MainPresenter
import innovappte.mobile.gamesinfo.mappers.FixtureVMMapper
import org.koin.dsl.module

val appModule = module {
    factory <MainActivityContract.Presenter>{ MainPresenter() }

    factory <FixturesFragmentContract.Presenter> { FixturesPresenter(get()) }
    factory <FixturesFragmentContract.Model> { FixturesModel(get(), get()) }
    factory { FixtureVMMapper() }
    factory <GetFixturesUseCase>{ GetFixturesUseCaseImpl(get()) }
}