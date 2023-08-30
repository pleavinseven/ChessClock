package com.pleavinseven.chessclock.ui

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pleavinseven.chessclock.MainViewModel
import com.pleavinseven.chessclock.Player
import com.pleavinseven.chessclock.R

val viewModel = MainViewModel()

@Composable
fun ChessClockApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PlayerCard(
            RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp),
            Modifier.weight(1f),
            Player(),
            viewModel.formattedTime,
            flip = true
        )
        CenterConsole(Modifier.weight(0.2f))
        PlayerCard(
            RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp),
            Modifier.weight(1f),
            Player(),
            viewModel.formattedTime
        )
    }
}

@Composable
private fun PlayerCard(
    roundedCornerShape: RoundedCornerShape,
    modifier: Modifier,
    player: Player,
    formattedTime: String,
    flip: Boolean = false
) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = roundedCornerShape,
        modifier = modifier
            .clickable {
                viewModel.onPlayerClick(player)
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = (if (flip) Modifier.rotate(180f) else Modifier),
                text = formattedTime,
                textAlign = TextAlign.Center,
                style = typography.displayLarge
            )
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
                { viewModel.onClickPause() },
                Icons.Rounded.Pause,
                stringResource(R.string.pause_button_desc)
            )
            CenterButton(
                { viewModel.onClickRefresh() },
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