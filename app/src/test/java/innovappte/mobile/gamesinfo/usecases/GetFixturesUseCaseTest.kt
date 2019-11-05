package innovappte.mobile.gamesinfo.usecases

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import innovappte.mobile.domain.repositories.FixturesRepository
import innovappte.mobile.domain.usecases.GetFixturesUseCase
import innovappte.mobile.domain.usecases.impl.GetFixturesUseCaseImpl
import innovappte.mobile.gamesinfo.MockModels
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GetFixturesUseCaseTest {
    private lateinit var getFixtureUseCase: GetFixturesUseCase
    private val fixturesRepository: FixturesRepository = mock()

    @Before
    fun setup() {
        getFixtureUseCase = GetFixturesUseCaseImpl(fixturesRepository)
    }

    @Test
    fun getFixtureTest() {
        // Given:
        val fixture = MockModels.getFixture()
        val results = listOf(fixture)
        whenever(fixturesRepository.getFixtures()).thenReturn(Single.just(results))

        // When:
        getFixtureUseCase.invoke()

        // Then:
        verify(fixturesRepository).getFixtures()
    }

}