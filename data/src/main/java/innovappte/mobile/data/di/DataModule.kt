package innovappte.mobile.data.di

import innovappte.mobile.data.repositories.FixturesRepositoryImpl
import innovappte.mobile.data.services.FixtureServiceProvider
import innovappte.mobile.domain.repositories.FixturesRepository
import org.koin.dsl.module

val dataModule = module {
    single<FixturesRepository> { FixturesRepositoryImpl(get()) }
    single { FixtureServiceProvider() }
}