package innovappte.mobile.gamesinfo

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.results.mvp.ResultsPresenter
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class ResultsPresenterTest {

    private val model: ResultFragmentContrat.Model = mock()

    private val view: ResultFragmentContrat.View = mock()

    private lateinit var presenter: ResultFragmentContrat.Presenter

    @Before
    fun setup() {
        presenter = ResultsPresenter(model)
        presenter.attachView(view)
    }

    @Test
    fun fillResultSuccessTest() {
        // Given:
        val results = listOf<ResultViewModel>()
        Mockito.`when`(model.getResults()).thenReturn(Single.just(results))
        Mockito.`when`(model.addMonthsDividers(results)).thenReturn(results)

        // When
        presenter.fillResults()

        // Then
        verify(view).updateResults(results)
    }

    @Test
    fun fillResultFailureTest() {
        // Given:
        val error = Exception("Network exception")
        whenever(model.getResults()).thenReturn(Single.error(error))

        // When:
        presenter.fillResults()

        // Then:
        verify(view).showNetworkError()
    }
}