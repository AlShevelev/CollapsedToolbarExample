package com.shevelev.collapsedtoolbarexample.first_example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import kotlin.math.abs
import kotlin.math.pow

@Composable
internal fun TopBarFixed(
    currentOffset: Float,
    maxOffset: Float
) {
    val alpha = (abs(currentOffset) / maxOffset).pow(2)

    TopAppBar() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Title",
                modifier = Modifier.alpha(alpha)
            )
        }
    }
}