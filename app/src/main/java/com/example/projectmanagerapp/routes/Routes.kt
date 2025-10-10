package com.example.projectmanagerapp.routes

/**
 * Defines all navigation routes used in the app.
 * - Add Project
 * - Project Detail
 * - Project Library
 * - About
 */
sealed class Routes (val routes : String) {
    /**
     * Route for adding a new project
     */
    object AddProject: Routes("AddProjectRoute")

    /**
     * Route for viewing project details.
     * Includes a [projectId] path parameter for navigation.
     * Use [go] to generate the full route string.
     */
    object ProjectDetail : Routes("DetailRoute/{projectId}"){
        fun go(projectId: Int) = "DetailRoute/$projectId"
    }

    /**
     * Route for viewing all projects in the library.
     */
    object ProjectLibrary : Routes("LibraryRoute")

    /**
     * Route for viewing About screen.
     */
    object About : Routes("AboutRoute")
}