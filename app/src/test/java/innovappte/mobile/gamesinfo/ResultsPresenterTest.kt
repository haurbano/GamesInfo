package innovappte.mobile.gamesinfo

import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.results.ResultFragmentContrat
import innovappte.mobile.gamesinfo.results.mvp.ResultsPresenter
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

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
        whenever(model.getResults()).thenReturn(Single.just(results))
        whenever(model.addMonthsDividers(results)).thenReturn(results)

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

    @Test
    fun `filter by competition with an empty string`(){
        // Given:
        val results = listOf<ResultViewModel>()
        val query = ""
        whenever(model.getResults()).thenReturn(Single.just(results))

        // When:
        presenter.filterByCompetition(query)

        // Then:
        verify(view).updateResults(results)
    }

    @Test
    fun `filter by competition when no result`(){
        // Given:
        val resultViewModel = MockModels.getResultViewModel()
        val results = listOf(resultViewModel)
        val query = "UEFA"
        whenever(model.getResults()).thenReturn(Single.just(results))

        // When:
        presenter.filterByCompetition(query)

        // Then:
        val captor = argumentCaptor<List<ViewType>>()
        verify(view).updateResults(captor.capture())
        assert(captor.firstValue.isEmpty())
    }
}