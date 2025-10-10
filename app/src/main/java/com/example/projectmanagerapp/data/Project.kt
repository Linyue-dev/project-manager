package com.example.projectmanagerapp.data

/**
 * Data class representing a project.
 * @param projectId Id of project
 * @param title Name of the project.
 * @param description Description of the project.
 * @param imageUrl Url link of project
 */
data class Project(val projectId: Int, val title: String, val description: String, var imageUrl: String)
