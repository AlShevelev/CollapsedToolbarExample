package com.shevelev.collapsedtoolbarexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shevelev.collapsedtoolbarexample.second_example.Root
import com.shevelev.collapsedtoolbarexample.ui.theme.CollapsedToolbarTheme

class SecondCaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CollapsedToolbarTheme {
                Root()
            }
        }
    }
}