package innovappte.mobile.gamesinfo.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.mainscreen.PagerFragment

class ResultsFragment : PagerFragment() {

    override fun getFragmentTitle() = "Results"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResultsFragment()
    }
}
