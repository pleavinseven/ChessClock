package com.pleavinseven.chessclock.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pleavinseven.chessclock.ConsoleViewModel
import com.pleavinseven.chessclock.R

val consoleViewModel = ConsoleViewModel()

@Composable
fun ChessClockApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Player( RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp), Modifier.weight(1f))
        CenterConsole(Modifier.weight(0.2f))
        Player( RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp), Modifier.weight(1f))
    }
}

@Composable
private fun Player(
    roundedCornerShape: RoundedCornerShape,
    modifier: Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = roundedCornerShape,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

        }
    }
}

@Composable
private fun CenterConsole(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CenterButton(
                { consoleViewModel.onClickPause() },
                Icons.Rounded.Pause,
                stringResource(R.string.pause_button_desc)
            )
            CenterButton(
                { consoleViewModel.onClickRefresh() },
                Icons.Rounded.Refresh,
                stringResource(R.string.refresh_button_desc)
            )
        }
    }
}

@Composable
fun CenterButton(onClick: () -> Unit, icon: ImageVector, iconDesc: String) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        onClick = onClick
    ) {
        Icon(icon, iconDesc)
    }
}