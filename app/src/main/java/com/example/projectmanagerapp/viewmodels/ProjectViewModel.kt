package com.example.projectmanagerapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.projectmanagerapp.data.Project


class ProjectViewModel : ViewModel(){
    private val _projects = mutableStateListOf<Project>()
    val projects : List<Project>
        get () = _projects

    private var nextId = 0

    fun addProject(title: String, description: String, imageUrl: String) : Int {
        nextId++
        val newProject = Project(nextId, title, description, imageUrl)
        _projects.add(newProject)
        return nextId
    }

    fun removeProject(project: Project){
        _projects.remove(project)
    }

    fun getProjectById (projectId: Int) : Project?{
        return _projects.find { it.projectId == projectId }
    }
}