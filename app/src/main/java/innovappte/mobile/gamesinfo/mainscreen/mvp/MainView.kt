package innovappte.mobile.gamesinfo.mainscreen.mvp

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.fixtures.FixturesFragment
import innovappte.mobile.gamesinfo.mainscreen.MainActivity
import innovappte.mobile.gamesinfo.mainscreen.MainActivityContract
import innovappte.mobile.gamesinfo.mainscreen.adapters.MainPagerAdapter
import innovappte.mobile.gamesinfo.results.ResultsFragment

class MainView(private val activity: MainActivity): MainActivityContract.View {

    private val mainPager: ViewPager = activity.findViewById(R.id.viewPagerMain)
    private val mainPagerAdapter by lazy { MainPagerAdapter(getMainFragmentList(), activity.supportFragmentManager) }

    override fun fillFragments() {
        mainPager.adapter = mainPagerAdapter
    }

    private fun getMainFragmentList(): List<Fragment> {
        return listOf(
            FixturesFragment.newInstance(),
            ResultsFragment.newInstance()
        )
    }

}