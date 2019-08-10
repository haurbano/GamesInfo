package innovappte.mobile.gamesinfo

import android.app.Application
import innovappte.mobile.data.di.dataModule
import innovappte.mobile.gamesinfo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }
    }
}