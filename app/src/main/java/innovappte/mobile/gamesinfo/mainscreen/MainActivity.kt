package innovappte.mobile.gamesinfo.mainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.mainscreen.mvp.MainView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val presenter: MainActivityContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(MainView(this))
        presenter.fillFragments()
    }
}
