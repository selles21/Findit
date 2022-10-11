package com.selles.ifindit.domain.usecase

import com.selles.ifindit.domain.entity.ITunesSearch
import com.selles.ifindit.domain.repository.FindItRepository
import com.selles.ifindit.utils.FindItHelperTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class GetITunesSearchUseCaseTest {
    private val findItRepository: FindItRepository = mockk(relaxed = true)
    private val getITunesSearchUseCase = GetITunesSearchUseCase(findItRepository)

    @Test
    fun `invoke Should return itunes search When repository is success`() {
        //Given
        val iTunesSearch = flow<ITunesSearch> { FindItHelperTest.iTunesSearch }
        coEvery {
            findItRepository.getITunesSearch("Johnson")
        } returns iTunesSearch

        //When
        val result = getITunesSearchUseCase("Johnson")

        //Then
        assertEquals(iTunesSearch, result)
    }

    @Test
    fun `invoke Should return itunes search When repository is failure`() {
        //Given
        coEvery {
            findItRepository.getITunesSearch("Johnson")
        } throws Throwable()

        //When
        val result = assertFails { getITunesSearchUseCase("Johnson") }

        //Then
        assertEquals(Throwable::class.java, result::class.java)
    }
}