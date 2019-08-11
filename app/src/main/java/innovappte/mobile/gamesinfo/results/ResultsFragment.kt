package innovappte.mobile.gamesinfo.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar

import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.adapters.FixtureAdapter
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.mainscreen.PagerFragment
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import kotlinx.android.synthetic.main.fragment_fixtures.*
import kotlinx.android.synthetic.main.fragment_results.*
import org.koin.android.ext.android.inject

class ResultsFragment : PagerFragment(), ResultFragmentContrat.View {

    private val presenter: ResultFragmentContrat.Presenter by inject()
    private val resultsAdapter by lazy { FixtureAdapter() }

    override fun getFragmentTitle() = "Results"

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

    companion object {
        @JvmStatic
        fun newInstance() = ResultsFragment()
    }
}
