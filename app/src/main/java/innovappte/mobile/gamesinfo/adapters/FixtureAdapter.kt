package innovappte.mobile.gamesinfo.adapters

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class FixtureAdapter @Inject constructor(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType> = ArrayList()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelagateAdapter>()

    init {
        delegateAdapters.put(ViewTypeValues.FIXTURE, FixtureDelegateAdapter())
        delegateAdapters.put(ViewTypeValues.RESULT, ResultsDelegateAdapter())
        delegateAdapters.put(ViewTypeValues.MONTH, MonthDividerDelegateAdapter())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters[viewType]!!.onCreateViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters[getItemViewType(position)]?.onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun refreshItems(data: List<ViewType>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}