package innovappte.mobile.gamesinfo.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import innovappte.mobile.gamesinfo.App

import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.adapters.FixtureAdapter
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.mainscreen.PagerFragment
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import kotlinx.android.synthetic.main.fragment_fixtures.*
import kotlinx.android.synthetic.main.fragment_results.*
import org.koin.android.ext.android.inject
import javax.inject.Inject

class ResultsFragment : PagerFragment(), ResultFragmentContrat.View {

    private val presenter: ResultFragmentContrat.Presenter by inject()

    @Inject
    lateinit var resultsAdapter: FixtureAdapter

    override fun getFragmentTitle() = "Results"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).applicationComponent.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        presenter.attachView(this)
        return view
    }

    override fun onStart() {
        super.onStart()
        addViewListeners()
        presenter.fillResults()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        rvResults.layoutManager = LinearLayoutManager(this.context)
        rvResults.adapter = resultsAdapter
    }

    override fun updateResults(results: List<ViewType>) {
        resultsAdapter.refreshItems(results)
    }

    override fun showNetworkError() {
        Snackbar.make(rvFixtures,getString(R.string.network_error_msg), Snackbar.LENGTH_LONG)
            .setAction(getString(R.string.retry_msg)) { presenter.fillResults() }
            .show()
    }

    private fun addViewListeners() {
        searchResults.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.filterByCompetition(query ?: "")
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                presenter.filterByCompetition(query ?: "")
                return true
            }

        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResultsFragment()
    }
}
