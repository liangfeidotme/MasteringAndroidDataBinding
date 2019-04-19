package me.liangfei.databinding.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "actors")
data class Actor(
        val name: String,
        val avatar: String,
        val birthday: String?,
        val realName: String?,
        val birthplace: String?,
        val office: String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var actorId: Int = 0
}
