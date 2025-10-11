package com.example.projectmanagerapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectmanagerapp.data.Project
import com.example.projectmanagerapp.routes.LocalNavController
import com.example.projectmanagerapp.ui.components.MainLayout
import com.example.projectmanagerapp.routes.Routes
import com.example.projectmanagerapp.viewmodels.ProjectViewModel

/**
 * Project Library screen.
 * Shows an empty state if there are no projects,
 * otherwise displays the project list.
 */
@Composable
fun ProjectLibrary ( projectViewModel: ProjectViewModel = viewModel()){
    val navController = LocalNavController.current
    val projects = projectViewModel.projects

    MainLayout(
        screenTitle = "Project Library"
    ) {
        if (projects.isEmpty()){
            EmptyProjectList()
        } else {
            ProjectList(
                projects = projectViewModel.projects,
                onDeleteProject = { projectViewModel.removeProject(it)},
                onProjectReviewClick = {
                    navController.navigate(Routes.ProjectDetail.go(it.projectId))
                }
            )
        }
    }
}

/**
 * Empty project list view.
 * Shows an icon, message, and button to add a new project.
 */
@Composable
fun EmptyProjectList(){
    val navController = LocalNavController.current
    Card (
        modifier = Modifier.padding(20.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Outlined.Folder,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "No Projects Yet",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Start building your portfolio!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.navigate(Routes.AddProject.routes) },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 12.dp,
                    hoveredElevation = 3.dp,
                ),
                shape = MaterialTheme.shapes.large,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add Project",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

/**
 * Project list.
 * Displays a list of projects with title, description,
 * and options to view details or delete.
 *
 * @param projects List of [Project] items to display.
 * @param onDeleteProject Callback triggered when a project is deleted.
 * @param onProjectReviewClick Callback triggered when a project card is clicked.
 */
@Composable
fun ProjectList(
    projects: List<Project>,
    onDeleteProject: (Project) -> Unit,
    onProjectReviewClick: (Project) -> Unit
){
    LazyColumn {
        items(projects){ project ->
            Card (
                modifier = Modifier
                    .padding( top = 20.dp, start = 20.dp, end= 20.dp, bottom = 6.dp)
                    .fillMaxWidth()
                    .clickable {onProjectReviewClick(project)},
                shape = MaterialTheme.shapes.large,
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ){
                Column {
                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(10.dp),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(
                        text = project.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(10.dp),
                    )
                }

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                )  {
                    IconButton(onClick = {
                        onDeleteProject(project)}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete")
                    }
                }
            }
        }
    }
}
