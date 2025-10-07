package com.example.projectmanagerapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectmanagerapp.routes.LocalNavController
import com.example.projectmanagerapp.routes.MainLayout
import com.example.projectmanagerapp.ui.preview.PreviewManager
import com.example.projectmanagerapp.viewmodels.ProjectViewModel
import kotlinx.coroutines.launch
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.graphics.Color

@Composable
fun ProjectCreation (projectViewModel: ProjectViewModel = viewModel()){
    val navController = LocalNavController.current
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var imageUrl by rememberSaveable { mutableStateOf("") }
    var projectId by rememberSaveable { mutableIntStateOf(0) }

    // Add scope
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    MainLayout(
        screenTitle = "Add Project",
        snackbarHostState = snackbarHostState
    ) {
        Column (
            modifier = Modifier.padding(20.dp)
        ){
            OutlinedTextField(
                value = title,
                onValueChange = {title = it},
                label = {
                    Text(
                        text = "Title",
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = MaterialTheme.colorScheme.primary
                )
            )
            OutlinedTextField(
                value = description,
                onValueChange = {description = it},
                label = {
                    Text(
                        text = "Description",
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(12.dp),
            )

            OutlinedTextField(
                value = imageUrl,
                onValueChange = {imageUrl = it},
                label = {
                    Text(
                        text = "Image Url link",
                        color = MaterialTheme.colorScheme.primary,

                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                shape = RoundedCornerShape(12.dp),
            )

            Button(
                onClick = {
                    if (title.isNotBlank()){
                        projectId = projectViewModel.addProject(title,description,imageUrl)
                        title = ""
                        description = ""
                        imageUrl = ""
                        navController.navigate("DetailRoute/$projectId")
                    } else {
                        scope.launch {
                            snackbarHostState.showSnackbar("Please enter a title")
                        }
                    }
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 8.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectCreationPreview() = PreviewManager { ProjectCreation () }