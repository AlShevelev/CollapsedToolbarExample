package com.shevelev.collapsedtoolbarexample.second_example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import kotlin.math.abs

@Composable
internal fun CoordinatedScroll(
    collapsingAreaHeightPx: MutableState<Float> = remember { mutableStateOf(0f) },
    content: @Composable (Float, NestedScrollConnection) -> Unit
) {
    val currentOffsetPx = remember { mutableStateOf(0f) }
    val currentAbsoluteOffsetPx = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y

                var absoluteOffset = currentAbsoluteOffsetPx.value + delta
                if (absoluteOffset > 0f) {
                    absoluteOffset = 0f
                }
                currentAbsoluteOffsetPx.value = absoluteOffset

                if (absoluteOffset >= -collapsingAreaHeightPx.value) {
                    currentOffsetPx.value = absoluteOffset
                } else {
                    currentOffsetPx.value = -collapsingAreaHeightPx.value
                }

                return when {
                    // The panel is completely collapsed - an internal scroll must be turned on
                    abs(currentOffsetPx.value) == collapsingAreaHeightPx.value -> Offset.Zero

                    // The panel is completely expanded - we must turn on an internal scroll
                    // to complete content scrolling
                    abs(currentOffsetPx.value) == 0f -> Offset.Zero

                    // Intermediate state - the scroll is blocked
                    else -> available
                }
            }
        }
    }

    content(
        currentOffsetPx.value,
        nestedScrollConnection
    )
}
