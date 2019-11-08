package innovappte.mobile.gamesinfo

import android.app.Application
import innovappte.mobile.data.di.dataModule
import innovappte.mobile.gamesinfo.dagger.ApplicationComponent
import innovappte.mobile.gamesinfo.dagger.DaggerApplicationComponent
import innovappte.mobile.gamesinfo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }
        applicationComponent = DaggerApplicationComponent.builder()
            .build()
    }
}