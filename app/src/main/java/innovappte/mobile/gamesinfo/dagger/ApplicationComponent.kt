package innovappte.mobile.gamesinfo.dagger

import dagger.Component
import innovappte.mobile.gamesinfo.App
import innovappte.mobile.gamesinfo.fixtures.FixturesFragment
import innovappte.mobile.gamesinfo.results.ResultsFragment

@Component
interface ApplicationComponent {
    fun inject(resultFragment: ResultsFragment)
    fun inject(fixtureFragment: FixturesFragment)
}