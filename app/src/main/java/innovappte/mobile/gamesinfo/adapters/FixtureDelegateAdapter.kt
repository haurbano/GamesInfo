package innovappte.mobile.gamesinfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import innovappte.mobile.gamesinfo.R
import innovappte.mobile.gamesinfo.viewmodels.FixtureViewModel
import kotlinx.android.synthetic.main.item_fixture.view.*

class FixtureDelegateAdapter: ViewTypeDelagateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = FixtureViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as FixtureViewHolder
        holder.bind(item as FixtureViewModel)
    }

    inner class FixtureViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_fixture, parent, false)
    ) {
        private val competitionName = itemView.txtCompetentionName
        private val venueName = itemView.txtVenueName
        private val matchDateAndTimeZone =  itemView.txtMatchDateAndTime
        private val homeTeam = itemView.txtHomeTeam
        private val awayTeam = itemView.txtAwayTeam
        private val dateFixture = itemView.txtDateFixture
        private val dayFixture = itemView.txtDayFixture

        fun bind(fixtureVM: FixtureViewModel) {
            with(fixtureVM) {
                competitionName.text = competitionStage.competition.name
                venueName.text = venue.name
                matchDateAndTimeZone.text = "$readableDate at $readableHour"
                this@FixtureViewHolder.homeTeam.text = homeTeam.name
                this@FixtureViewHolder.awayTeam.text = awayTeam.name
            }
        }
    }
}