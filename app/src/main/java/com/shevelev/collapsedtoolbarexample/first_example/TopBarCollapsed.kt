package com.shevelev.collapsedtoolbarexample.first_example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.roundToInt

@Composable
internal fun TopBarCollapsed(
    currentOffset: Float,
    maxOffset: Float,
    onHeightCalculated: (Float) -> Unit
) {
    val alpha = (abs(currentOffset) / maxOffset).pow(0.75f)

    Column(
        modifier = Modifier
            .zIndex(1f)
            .offset { IntOffset(x = 0, y = currentOffset.roundToInt()) }
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(start = 16.dp)
            .onGloballyPositioned {
                onHeightCalculated(it.size.height.toFloat())
            }
    ) {
        Text(
            text = "Some text 1",
            color = Color.White,
            modifier = Modifier.alpha(1f - alpha).padding(top = 8.dp)
        )
        Text(
            text = "Some text 2",
            color = Color.White,
            modifier = Modifier.alpha(1f - alpha)
        )

        Text(
            text = "Some text 3",
            color = Color.White,
            modifier = Modifier.alpha(1f - alpha).padding(bottom = 8.dp)
        )
    }
}