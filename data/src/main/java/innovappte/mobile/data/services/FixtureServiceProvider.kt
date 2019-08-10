package innovappte.mobile.data.services

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FixtureServiceProvider {

    private object Config{
        const val BASE_URL = "https://storage.googleapis.com/cdn-og-test-api/test-task/"
    }

    private val retrofitClient by lazy {
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun get(): FixtureService {
        return retrofitClient.create(FixtureService::class.java)
    }

}