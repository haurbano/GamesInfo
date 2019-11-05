package innovappte.mobile.gamesinfo.presenters

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import innovappte.mobile.gamesinfo.fixtures.FixturesFragmentContract
import innovappte.mobile.gamesinfo.fixtures.mvp.FixturesPresenter
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class FixturePresenterTest {

    private val model: FixturesFragmentContract.Model = mock()
    private val view: FixturesFragmentContract.View = mock()
    lateinit var presenter: FixturesFragmentContract.Presenter

    @Before
    fun setup() {
        presenter = FixturesPresenter(model)
        presenter.attachView(view)
    }

    @Test
    fun fillFixturesSuccessTest() {
        // Given:
        val results = listOf<FixtureViewModel>()
        Mockito.`when`(model.getFixtures()).thenReturn(Single.just(results))
        Mockito.`when`(model.addMonthsDividers(results)).thenReturn(results)

        // When:
        presenter.fillFixtures()

        // Then:
        verify(view).updateFixtures(results)
    }

    @Test
    fun fillFixturesFailureTest() {
        // Given:
        val error = Exception("Network exception")
        whenever(model.getFixtures()).thenReturn(Single.error(error))

        // When:
        presenter.fillFixtures()

        // Then:
        verify(view).showErrorGettingFixtures()
    }
}