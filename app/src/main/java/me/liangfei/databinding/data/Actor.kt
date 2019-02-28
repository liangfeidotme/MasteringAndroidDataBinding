package me.liangfei.databinding.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "actors")
data class Actor(
        @PrimaryKey @ColumnInfo(name = "id")
        val actorId: String,
        val name: String,
        val birthday: Date?,
        val pictureUrl: String
)
