package com.example.projectmanagerapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.projectmanagerapp.data.Project


class ProjectViewModel : ViewModel(){
    private val _projects = mutableStateListOf<Project>()
    val projects : List<Project>
        get () = _projects

    fun addProject(title: String, description: String, imageUrl: String)  {
        val newProject = Project( title, description, imageUrl)
    }

    fun removeProject(project: Project){
        _projects.remove(project)
    }
}