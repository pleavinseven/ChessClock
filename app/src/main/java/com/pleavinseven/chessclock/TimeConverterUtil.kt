package com.pleavinseven.chessclock

import java.time.Duration

class TimeConverterUtil {

    fun formatTime(timeMillis: Long): String {
        var timeLeft = Duration.ofMillis(timeMillis)
        val hours = timeLeft.toHours()
        timeLeft = timeLeft.minusHours(hours)
        val minutes = timeLeft.toMinutes()
        timeLeft = timeLeft.minusMinutes(minutes)
        val seconds = timeLeft.seconds
        timeLeft = timeLeft.minusSeconds(seconds)
        val millis = timeLeft.toMillis() / 10
        return String.format(
            "%02d:%02d:%02d:%02d",
            hours, minutes, seconds, millis
        )
    }

}