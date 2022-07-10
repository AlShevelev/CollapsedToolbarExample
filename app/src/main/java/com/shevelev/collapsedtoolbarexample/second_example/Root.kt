package com.shevelev.collapsedtoolbarexample.second_example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Composable
internal fun Root() {
    val toolbarHeightPx = remember { mutableStateOf(0f) }
    val topPanelOffset = remember { mutableStateOf(0f) }

    Scaffold(
        topBar = {
            TopBarFixed(
                maxOffset = toolbarHeightPx.value,
                currentOffset = topPanelOffset.value
            )
        }
    ) {
        CoordinatedScroll(
            collapsingAreaHeightPx = toolbarHeightPx
        ) { offset, nestedScroll ->
            topPanelOffset.value = offset

            Box(
                Modifier
                    .fillMaxSize()
                    .nestedScroll(nestedScroll)
            ) {
                TopBarCollapsed(
                    currentOffset = offset,
                    maxOffset = toolbarHeightPx.value,
                    onHeightCalculated = {
                        toolbarHeightPx.value = it
                    }
                )

                val contentPadding = with(LocalDensity.current) {
                    toolbarHeightPx.value.toInt().toDp() - abs(offset).toDp()
                }

                ScrollableContent(
                    contentTopPadding = contentPadding,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}