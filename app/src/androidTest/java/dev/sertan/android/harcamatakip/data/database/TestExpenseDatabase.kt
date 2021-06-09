package dev.sertan.android.harcamatakip.data.database

import androidx.test.filters.SmallTest
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dev.sertan.android.harcamatakip.FakeExpenseDatabase
import dev.sertan.android.harcamatakip.data.model.Expense
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@SmallTest
@HiltAndroidTest
class TestExpenseDatabase {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    @FakeExpenseDatabase
    lateinit var db: ExpenseDatabase

    @Before
    fun setup() = hiltRule.inject()

    @After
    fun teardown() = db.close()

    @Test
    fun isDatabaseOpen() = runBlocking {
        db.expenseDao().insert(Expense())
        Truth.assertThat(db.isOpen).isTrue()
    }
}