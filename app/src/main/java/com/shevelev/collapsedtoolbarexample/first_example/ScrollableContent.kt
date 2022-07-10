package com.shevelev.collapsedtoolbarexample.first_example

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableContent(
    contentTopPadding: Dp,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(top = contentTopPadding),
        modifier = modifier
    ) {
        items(100) { index ->
            Text("I'm item $index", modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))
        }
    }
}