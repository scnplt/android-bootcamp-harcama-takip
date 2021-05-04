package dev.sertan.android.harcamatakip.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
data class Expense(
    var desc: String = "",
    var amount: Double = 0.0,
    var category: SpendCategory = SpendCategory.OTHER,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
)