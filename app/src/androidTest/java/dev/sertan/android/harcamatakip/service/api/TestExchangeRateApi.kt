package dev.sertan.android.harcamatakip.service.api

import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@SmallTest
@HiltAndroidTest
class TestExchangeRateApi {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var api: ExchangeRateApi

    @Before
    fun setup() = hiltRule.inject()

    @Test
    fun isResponseOfGetMethodSuccessful() = runBlocking {
        val response = api.get()
        Truth.assertThat(response.isSuccessful).isTrue()
    }
}