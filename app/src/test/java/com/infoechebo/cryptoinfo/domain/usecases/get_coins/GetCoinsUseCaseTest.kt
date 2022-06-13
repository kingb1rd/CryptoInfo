package com.infoechebo.cryptoinfo.domain.usecases.get_coins

import com.infoechebo.cryptoinfo.domain.repository.CoinRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before

class GetCoinsUseCaseTest {
    @RelaxedMockK
    private lateinit var repository: CoinRepository

    private lateinit var getCoinsUseCase: GetCoinsUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getCoinsUseCase = GetCoinsUseCase(repository)
    }
}