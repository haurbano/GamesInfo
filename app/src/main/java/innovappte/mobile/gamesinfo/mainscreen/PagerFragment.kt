package innovappte.mobile.gamesinfo.mainscreen

import androidx.fragment.app.Fragment

abstract class PagerFragment: Fragment() {
    abstract fun getFragmentTitle(): String
}