package innovappte.mobile.gamesinfo.fixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import innovappte.mobile.domain.models.Fixture
import innovappte.mobile.gamesinfo.App

import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.adapters.FixtureAdapter
import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.mainscreen.PagerFragment
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import kotlinx.android.synthetic.main.fragment_fixtures.*
import org.koin.android.ext.android.inject
import javax.inject.Inject

class FixturesFragment : PagerFragment(), FixturesFragmentContract.View {

    private val presenter : FixturesFragmentContract.Presenter by inject()

    @Inject
    lateinit var fixtureAdapter: FixtureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as App).applicationComponent.inject(this)
    }

    override fun getFragmentTitle() = "Fixtures"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fixtures, container, false)
        presenter.attachView(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        presenter.fillFixtures()
    }

    override fun updateFixtures(fixtures: List<ViewType>) {
        fixtureAdapter.refreshItems(fixtures)
    }

    override fun showErrorGettingFixtures() {
        Snackbar.make(rvFixtures,getString(R.string.network_error_msg), Snackbar.LENGTH_LONG)
            .setAction(getString(R.string.retry_msg)) { presenter.fillFixtures()}
            .show()
    }

    private fun setUpRecyclerView() {
        rvFixtures.adapter = fixtureAdapter
        rvFixtures.layoutManager = LinearLayoutManager(this.context)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FixturesFragment()
    }
}
