package com.selles.ifindit.data.source

import app.cash.turbine.test
import com.selles.ifindit.data.api.FindItService
import com.selles.ifindit.utils.FindItHelperTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class FindItDataSourceImplTest {

    private val findItService: FindItService = mockk()
    private val findItDataSource = FindItDataSourceImpl(findItService)

    @Test
    fun `getITunesSearch Should return success`() = runBlocking {
        //Given
        val findItResponse = FindItHelperTest.iTunesSearchResponse
        coEvery {
            findItService.getITunesSearch(
                "Johnson",
                "music",
                "song",
                "",
                15
            )
        } returns findItResponse

        //When
        val result = findItDataSource.getITunesSearch("Johnson")

        //Then
        result.test {
            coVerify {
                findItService.getITunesSearch(
                    "Johnson",
                    "music",
                    "song",
                    "",
                    15
                )
            }
            assertEquals(findItResponse, expectItem())
            expectComplete()
        }
    }

    @Test
    fun `getITunesSearch Should return error`() = runBlocking {
        //Given
        val error = Throwable()
        coEvery {
            findItService.getITunesSearch(
                "Johnson",
                "music",
                "song",
                "",
                15
            )
        } throws error

        ///When
        val result = findItDataSource.getITunesSearch("Johnson")

        result.test {
            coVerify {
                findItService.getITunesSearch(
                    "Johnson",
                    "music",
                    "song",
                    "",
                    15
                )
            }
            assertEquals(error, expectError())
            expectNoEvents()
        }
    }
}