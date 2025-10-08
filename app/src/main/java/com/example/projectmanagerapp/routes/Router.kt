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

