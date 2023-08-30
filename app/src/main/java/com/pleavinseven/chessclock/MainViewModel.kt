package com.pleavinseven.chessclock

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val startMillis = Millis.ONE.time
    private val timeConverterUtil = TimeConverterUtil()
    private val _remainingTime = MutableStateFlow(startMillis)

    var formattedTime by mutableStateOf(timeConverterUtil.formatTime(startMillis))


    fun onClickRefresh() {
        TODO("Not yet implemented")
    }

    fun onClickPause() {
        println(_remainingTime.value)
    }

    fun onPlayerClick(player: Player) {
        player.isRunning = !player.isRunning
        if (player.isRunning) {
            runClock()
        }
    }


    private fun runClock() {
        val timer = object : CountDownTimer(startMillis, 1) {
            override fun onTick(millisUntilFinished: Long) {
                _remainingTime.value -= 1
                formattedTime = timeConverterUtil.formatTime(_remainingTime.value)
            }

            override fun onFinish() {
                println("done")
            }
        }
        timer.start()

    }
}