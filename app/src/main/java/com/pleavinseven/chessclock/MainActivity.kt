package com.pleavinseven.chessclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pleavinseven.chessclock.ui.ChessClockApp
import com.pleavinseven.chessclock.ui.theme.ChessClockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessClockTheme {
                ChessClockApp()
            }
        }
    }
}

