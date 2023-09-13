package com.example.testapp040923.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.testapp040923.Screen1Model

@Composable
fun TestFun(
    currentInfoScreen1: MutableState<Screen1Model>
) {
    Row(modifier = Modifier.fillMaxSize()) {
        Text(text = "адрес отлея: ${currentInfoScreen1.value.name}")

    }
}