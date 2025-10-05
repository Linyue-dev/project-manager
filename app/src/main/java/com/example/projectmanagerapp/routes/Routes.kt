package com.example.projectmanagerapp.routes

sealed class Routes (val routes : String) {
    object AddProject: Routes("AddProjectRoute")
    object ProjectDetail : Routes("DetailRoute/"){
        fun go(projectId: Int) = "DetailRoute/$projectId"
    }
    object ProjectLibrary : Routes("LibraryRoute")
    object About : Routes("AboutRoute")
}