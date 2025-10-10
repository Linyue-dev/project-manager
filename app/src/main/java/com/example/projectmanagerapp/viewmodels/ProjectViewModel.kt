package com.example.projectmanagerapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.projectmanagerapp.data.Project

/**
 * ViewModel for managing the list of projects.
 *
 * Handles adding, removing, and retrieving projects.
 * Uses a MutableStateList so UI updates automatically when the list changes.
 */
class ProjectViewModel : ViewModel(){
    private val _projects = mutableStateListOf<Project>()
    val projects : List<Project>
        get () = _projects

    private var nextId = 0

    /**
     * Add a new project.
     * @return the ID of the newly added project.
     */
    fun addProject(title: String, description: String, imageUrl: String) : Int {
        nextId++
        val newProject = Project(nextId, title, description, imageUrl)
        _projects.add(newProject)
        return nextId
    }
    /**
     * Remove a project from the list.
     */
    fun removeProject(project: Project){
        _projects.remove(project)
    }

    /**
     * Find a project by its ID.
     * @return the project if found, otherwise null.
     */
    fun getProjectById (projectId: Int) : Project?{
        return _projects.find { it.projectId == projectId }
    }
}