package com.example.mynotes.converter

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date:Date):Long{
        return date.time
    }

    @TypeConverter
    fun dateFromTimesStamp(timestamp: Long): Date?{
        return Date(timestamp)
    }
}