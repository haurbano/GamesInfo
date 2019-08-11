package innovappte.mobile.gamesinfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.viewmodels.MonthDividerViewModel
import kotlinx.android.synthetic.main.item_month.view.*

class MonthDividerDelegateAdapter : ViewTypeDelagateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return MonthDividerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as MonthDividerViewHolder
        holder.bind(item as MonthDividerViewModel)
    }

    inner class MonthDividerViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_month, parent, false)
    ){
        private val monthName = itemView.txtMonthDivider

        fun bind(month: MonthDividerViewModel) {
            monthName.text = month.monthName
        }
    }
}