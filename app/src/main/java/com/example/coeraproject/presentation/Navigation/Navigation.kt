package com.example.coeraproject.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.coeraproject.presentation.PlanetsViewModel
import com.example.coeraproject.presentation.Screens.PlanetScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "PlanetsPage") {
        composable("PlanetsPage") {
            val viewModel = hiltViewModel<PlanetsViewModel>()

            val state by viewModel.state.collectAsState()

            PlanetScreen(state = state)
        }
    }
}