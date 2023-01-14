package com.selles.ifindit.data.integration

import com.google.common.truth.Truth.assertThat
import com.selles.ifindit.data.api.FindItService
import com.selles.ifindit.data.mapper.ITunesSearchMapper
import com.selles.ifindit.data.mapper.SearchResultMapper
import com.selles.ifindit.data.repository.FindItRepositoryImpl
import com.selles.ifindit.data.source.FindItDataSourceImpl
import com.selles.ifindit.di.createRetrofit
import com.selles.ifindit.domain.repository.FindItRepository
import com.selles.ifindit.utils.FindItHelperTest
import com.selles.ifindit.utils.readFile
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit


class FindItRepositoryIntegrationTest {

    private val mockWebServer = MockWebServer()
    private val baseUrl = mockWebServer.url("/").toString()
    private val retrofit = createRetrofit(baseUrl)
    private var service = retrofit.create(FindItService::class.java)
    private val repository = createRepository(retrofit)


    private fun createRepository(retrofit: Retrofit): FindItRepository {
        val findItDataSource = FindItDataSourceImpl(service)
        val iTunesSearchMapper = ITunesSearchMapper(SearchResultMapper())
        return FindItRepositoryImpl(findItDataSource, iTunesSearchMapper)
    }

    @Test
    fun `getITunesSearch Should return a mapped ITunesSearch`() = runBlocking {
        //Given
        val expectedITunesSearch = FindItHelperTest.iTunesSearchResponse

        service = retrofit.create(FindItService::class.java)
        mockWebServer.enqueue(MockResponse().setBody(readFile(SUCCESS_RESPONSE)))

        val result = service.getITunesSearch("Johnson", "music", "song", "", 1)

        val request = mockWebServer.takeRequest()

        assertThat(request.path).isEqualTo("/search?term=Johnson&media=music&entity=song&attribute=&limit=1")
        assertThat(result).isEqualTo(expectedITunesSearch)

    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}