package com.pleavinseven.chessclock

import android.text.format.DateUtils

class TimeConverterUtil {

    fun formatTime(timeMillis: Long): String {
        return DateUtils.formatElapsedTime(timeMillis / 1000)
    }

}