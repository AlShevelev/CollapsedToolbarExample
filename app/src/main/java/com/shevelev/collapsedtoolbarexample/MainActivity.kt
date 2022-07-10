package com.shevelev.collapsedtoolbarexample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
//import com.shevelev.collapsedtoolbarexample.first_example.Root
import com.shevelev.collapsedtoolbarexample.second_example.Root
import com.shevelev.collapsedtoolbarexample.ui.theme.CollapsedToolbarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = LocalContext.current

            CollapsedToolbarTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Button(
                        onClick = { startActivity(Intent(context, FirstCaseActivity::class.java)) },
                        modifier = Modifier.padding(bottom = 16.dp)
                    ) {
                        Text("First case")
                    }

                    Button(
                        onClick = { startActivity(Intent(context, SecondCaseActivity::class.java)) }
                    ) {
                        Text("Second case")
                    }
                }
            }
        }
    }
}