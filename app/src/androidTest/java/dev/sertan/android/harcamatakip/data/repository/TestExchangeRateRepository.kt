package dev.sertan.android.harcamatakip.data.repository

import android.content.Context
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@SmallTest
@HiltAndroidTest
class TestExchangeRateRepository {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repo: ExchangeRateRepository

    @Inject
    @ApplicationContext
    lateinit var context: Context

    @Before
    fun setup() = hiltRule.inject()

    @Test
    fun getExchangeRates() = runBlocking {
        Truth.assertThat(repo.getExchangeRates()).isTrue()
    }
}