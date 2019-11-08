package innovappte.mobile.gamesinfo.di

import innovappte.mobile.domain.usecases.GetFixturesUseCase
import innovappte.mobile.domain.usecases.GetResultsUseCase
import innovappte.mobile.domain.usecases.impl.GetFixturesUseCaseImpl
import innovappte.mobile.domain.usecases.impl.GetResultsUseCaseImpl
import innovappte.mobile.gamesinfo.adapters.FixtureAdapter
import innovappte.mobile.gamesinfo.fixtures.FixturesFragmentContract
import innovappte.mobile.gamesinfo.fixtures.mvp.FixturesModel
import innovappte.mobile.gamesinfo.fixtures.mvp.FixturesPresenter
import innovappte.mobile.gamesinfo.mainscreen.MainActivityContract
import innovappte.mobile.gamesinfo.mainscreen.mvp.MainPresenter
import innovappte.mobile.gamesinfo.mappers.DateMapper
import innovappte.mobile.gamesinfo.mappers.FixtureVMMapper
import innovappte.mobile.gamesinfo.mappers.ResultVMMapper
import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.results.mvp.ResultsModel
import innovappte.mobile.gamesinfo.results.mvp.ResultsPresenter
import org.koin.dsl.module

val appModule = module {
    factory <MainActivityContract.Presenter>{ MainPresenter() }

    factory <FixturesFragmentContract.Presenter> { FixturesPresenter(get()) }
    factory <FixturesFragmentContract.Model> { FixturesModel(get(), get()) }
    factory { FixtureVMMapper(get()) }
    factory <GetFixturesUseCase>{ GetFixturesUseCaseImpl(get()) }

    factory <ResultFragmentContrat.Presenter>{ ResultsPresenter(get()) }
    factory <ResultFragmentContrat.Model>{ ResultsModel(get(), get()) }
    factory <GetResultsUseCase>{ GetResultsUseCaseImpl(get()) }
    factory { ResultVMMapper(get()) }

    factory { DateMapper() }
}