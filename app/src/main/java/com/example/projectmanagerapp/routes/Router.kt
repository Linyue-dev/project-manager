package com.example.projectmanagerapp.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projectmanagerapp.ui.screens.ProjectCreation
import com.example.projectmanagerapp.ui.screens.ProjectDetail
import com.example.projectmanagerapp.ui.screens.ProjectLibrary
import com.example.projectmanagerapp.ui.screens.About
import com.example.projectmanagerapp.viewmodels.ProjectViewModel


/**
 * Provides access to the current [NavHostController] throughout the app.
 *
 * Used with [CompositionLocalProvider] to make [NavController] available
 * to all composables without passing it explicitly as a parameter.
 */
val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavController provided")
}

/**
 * Main navigation router for the app.
 * Sets up navigation graph using [NavHost] and defines all composable destinations.
 * Shares a single [ProjectViewModel] instance across screens.
 *
 * Routes:
 * Routes.About -> About Screen
 * Routes.AddProject -> Add project
 * Routes.ProjectDetail -> Project detail
 * Routes.ProjectLibrary -> Project list
 *
 */
@Composable
fun Router(){
    val navController = rememberNavController()
    val projectViewModel : ProjectViewModel = viewModel()

    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.About.routes,
        ){
            composable (Routes.AddProject.routes) {ProjectCreation(projectViewModel = projectViewModel) }
            composable(
                route = Routes.ProjectDetail.routes, //route = "DetailRoute/{projectId}",
                arguments = listOf(
                    navArgument("projectId") {type = NavType.IntType}
                )
            ) { backStackEntry ->
                val projectId = backStackEntry.arguments?.getInt("projectId")?:-1
                val project = projectViewModel.getProjectById(projectId)
                if (project != null){
                    ProjectDetail(project)
                }
            }
            composable (Routes.ProjectLibrary.routes) { ProjectLibrary (projectViewModel = projectViewModel)}
            composable (Routes.About.routes) { About() }
        }
    }
}

