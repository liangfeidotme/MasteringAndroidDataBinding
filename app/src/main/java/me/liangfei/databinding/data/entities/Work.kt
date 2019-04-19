package me.liangfei.databinding.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "works")
data class Work(
        val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
