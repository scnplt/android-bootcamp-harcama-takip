package dev.sertan.android.harcamatakip.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "expense_table")
data class Expense(
    var desc: String = "",
    var amount: Double = 0.0,
    var category: SpendCategory = SpendCategory.OTHER,
    var currency: Currency = Currency.LIRA,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
) : Serializable {
    fun amountConvert(exchangeRate: ExchangeRate?, to: Currency?): Double {
        if (exchangeRate == null || to == null) return 0.0
        val baseCurrencyRate = exchangeRate.data[currency.code] ?: 1.0
        val targetCurrencyRate = exchangeRate.data[to.code] ?: 1.0
        return amount * targetCurrencyRate / baseCurrencyRate
    }
}