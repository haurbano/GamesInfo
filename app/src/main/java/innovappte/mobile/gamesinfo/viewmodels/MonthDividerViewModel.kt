package innovappte.mobile.gamesinfo.viewmodels

import innovappte.mobile.gamesinfo.adapters.ViewType
import innovappte.mobile.gamesinfo.adapters.ViewTypeValues

class MonthDividerViewModel(val monthName: String): ViewType {
    override fun getViewType() = ViewTypeValues.MONTH
}