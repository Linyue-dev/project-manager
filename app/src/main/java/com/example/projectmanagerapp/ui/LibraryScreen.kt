package com.example.projectmanagerapp.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectmanagerapp.routes.LocalNavController
import com.example.projectmanagerapp.routes.MainLayout
import com.example.projectmanagerapp.routes.Routes
import com.example.projectmanagerapp.viewmodels.ProjectViewModel

@Composable
fun ProjectLibrary ( projectViewModel: ProjectViewModel = viewModel()){
    val navController = LocalNavController.current
    val projects = projectViewModel.projects

    MainLayout(
        screenTitle = "Project Library"
    ) {
        if (projects.isEmpty()){
            Card (
                modifier = Modifier.padding(15.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ){
                Column {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text("There are no projects at the moment.")
                    Spacer(modifier = Modifier.padding(6.dp))
                    Text("Please click the + button below to add one.")
                }
            }
        } else {
            LazyColumn {
                items(projects){ project ->
                    Card (
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ){
                        Column {
                            Text( project.title)

                            Spacer(modifier = Modifier.padding(10.dp))

                            Text(project.description)
                        }

                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        )  {

                            IconButton(onClick = {
                                navController.navigate("DetailRoute/${project.projectId}")}
                            ) {
                                Icon(Icons.Default.Edit, contentDescription = "Edit")
                            }

                            IconButton(onClick = {
                                projectViewModel.removeProject(project)}
                            ) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}

