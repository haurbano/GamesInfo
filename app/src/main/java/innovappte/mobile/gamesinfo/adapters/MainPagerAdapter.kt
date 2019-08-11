package innovappte.mobile.gamesinfo.adapters


import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import innovappte.mobile.gamesinfo.mainscreen.PagerFragment

class MainPagerAdapter(
    private val fragments: List<PagerFragment>,
    fragmentManager: FragmentManager
): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int): CharSequence? {
        return fragments[position].getFragmentTitle()
    }
}