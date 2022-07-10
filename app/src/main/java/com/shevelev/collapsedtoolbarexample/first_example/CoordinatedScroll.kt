package com.shevelev.collapsedtoolbarexample.first_example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource

/**
 * @param content parameters are:
 * offset of a toolbar;
 * connection to nested scroll system
 */
@Composable
internal fun CoordinatedScroll(
    collapsingAreaHeightPx: MutableState<Float> = remember { mutableStateOf(0f) },
    content: @Composable (Float, NestedScrollConnection) -> Unit
) {
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
    val currentAbsoluteOffsetPx = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
                val delta = available.y

                var absoluteOffset = currentAbsoluteOffsetPx.value + delta
                if(absoluteOffset > 0f) {
                    absoluteOffset = 0f
                }
                currentAbsoluteOffsetPx.value = absoluteOffset

                if(absoluteOffset >= -collapsingAreaHeightPx.value) {
                    toolbarOffsetHeightPx.value = absoluteOffset
                } else {
                    toolbarOffsetHeightPx.value = -collapsingAreaHeightPx.value
                }

                return Offset.Zero
            }
        }
    }

    content(
        toolbarOffsetHeightPx.value,
        nestedScrollConnection
    )
}
