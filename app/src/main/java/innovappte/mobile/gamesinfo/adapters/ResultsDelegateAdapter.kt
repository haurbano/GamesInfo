package innovappte.mobile.gamesinfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.viewmodels.ResultViewModel
import kotlinx.android.synthetic.main.item_result.view.*

class ResultsDelegateAdapter : ViewTypeDelagateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = ResultViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ResultViewHolder
        holder.bind(item as ResultViewModel)
    }

    inner class ResultViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
    ) {
        private val competitionName = itemView.txtCompetentionName
        private val venueName = itemView.txtVenueName
        private val matchDateAndTimeZone =  itemView.txtMatchDateAndTime
        private val homeTeam = itemView.txtHomeTeam
        private val awayTeam = itemView.txtAwayTeam
        private val homeGoals = itemView.txtHomeGoals
        private val awayGoals = itemView.txtAwayGoals

        fun bind(fixtureVM: ResultViewModel) {
            with(fixtureVM) {
                competitionName.text = competitionStage.competition.name
                venueName.text = venue.name
                matchDateAndTimeZone.text = "$readableDate at $readableHour"
                this@ResultViewHolder.homeTeam.text = homeTeam.name
                this@ResultViewHolder.awayTeam.text = awayTeam.name
                homeGoals.text = score?.home.toString()
                awayGoals.text = score?.away.toString()
            }
        }
    }
}