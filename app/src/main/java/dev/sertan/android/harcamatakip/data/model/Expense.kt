package dev.sertan.android.harcamatakip.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "expense_table")
data class Expense(
    var desc: String = "",
    var cost: Double = 0.0,
    var category: SpendCategory = SpendCategory.OTHER,
    var currency: Currency = Currency.LIRA,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0
) : Parcelable {
    fun costConvert(exchangeRate: ExchangeRate?, to: Currency?): Double {
        val baseCurrencyRate = exchangeRate?.data?.get(currency.code) ?: 1.0
        val targetCurrencyRate = exchangeRate?.data?.get(to?.code) ?: 1.0
        return cost * targetCurrencyRate / baseCurrencyRate
    }
}