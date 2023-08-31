package com.pleavinseven.chessclock

import org.junit.Assert.assertEquals
import org.junit.Test

class TimeConverterUtilTest {

    private val oneHour = 3600000L
    private val oneMinute = 60000L
    private val oneSecond = 1000L
    private val tenMillis = 10L
    private val testMillis = oneHour + oneMinute + oneSecond + tenMillis

    @Test
    fun testFormatTime_ReturnCorrectString() {
        assertEquals("01:01:01:01", TimeConverterUtil().formatTime(testMillis))
    }
}