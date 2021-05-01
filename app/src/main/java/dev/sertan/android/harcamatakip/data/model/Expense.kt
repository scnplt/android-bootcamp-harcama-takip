package dev.sertan.android.harcamatakip.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "expense_table")
data class Expense(
    val desc: String = "",
    val amount: Float = 1f,
    val type: Type = Type.OTHER,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
) {
    companion object {
        enum class Type(val code: Byte) {
            SHOP(0),
            RENT(1),
            BILL(2),
            OTHER(3);

            companion object {
                fun toType(code: Byte): Type = values().find { it.code == code } ?: OTHER
            }
        }

        class Converter {
            @TypeConverter
            fun toType(code: Byte): Type = Type.toType(code)

            @TypeConverter
            fun fromType(type: Type): Byte = type.code
        }
    }
}