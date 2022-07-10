package com.shevelev.collapsedtoolbarexample.second_example

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableContent(
    contentTopPadding: Dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(top = contentTopPadding),
        backgroundColor = Color.Companion.LightGray,
        shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            items(100) { index ->
                Text("I'm item $index", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
        }
    }
}