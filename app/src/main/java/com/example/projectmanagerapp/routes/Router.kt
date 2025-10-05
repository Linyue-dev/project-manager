package com.example.projectmanagerapp.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectmanagerapp.ui.ProjectCreation
import com.example.projectmanagerapp.viewmodels.ProjectViewModel


// global variable for navigation
val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavController provided")
}

@Composable
fun Router(){
    val navController = rememberNavController()
    val projectViewModel : ProjectViewModel = viewModel()

    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        NavHost(
            navController = navController,
            startDestination = "AddProjectRoute",
        ){
            composable ("AddProjectRoute") {ProjectCreation(projectViewModel = projectViewModel) }
            composable ("DetailRoute") { }
            composable ("LibraryRoute") { }
            composable ("AboutRoute") { }
        }
    }
}
