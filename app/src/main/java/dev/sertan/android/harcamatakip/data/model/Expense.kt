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
) : Parcelable
