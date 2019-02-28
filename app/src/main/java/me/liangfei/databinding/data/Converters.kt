package me.liangfei.databinding.data

import androidx.room.TypeConverter
import java.util.*


class Converters {
    @TypeConverter
    fun timestampToDate(value: Long?) = value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?) = date?.time
}