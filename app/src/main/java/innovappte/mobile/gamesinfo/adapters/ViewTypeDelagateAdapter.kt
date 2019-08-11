package innovappte.mobile.gamesinfo.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface ViewTypeDelagateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}