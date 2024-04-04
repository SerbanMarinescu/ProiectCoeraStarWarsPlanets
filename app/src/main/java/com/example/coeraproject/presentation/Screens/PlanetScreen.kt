package com.example.coeraproject.presentation.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun PlanetScreen(
    state: List<String>,

) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state) {
            Text(
                text = it,
                fontSize = 20.sp
            )
        }
    }
}