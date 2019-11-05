package innovappte.mobile.gamesinfo

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import innovappte.mobile.gamesinfo.mainscreen.MainActivityContract
import innovappte.mobile.gamesinfo.mainscreen.mvp.MainPresenter
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private val mainView: MainActivityContract.View = mock()

    private val presenter = MainPresenter()

    @Before
    fun setup() {
        presenter.attachView(mainView)
    }

    @Test
    fun fillFragmentTest() {
        presenter.fillFragments()
        verify(mainView).fillFragments()
    }
}