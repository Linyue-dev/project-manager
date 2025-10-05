package com.example.projectmanagerapp.ui

import android.media.midi.MidiDevice
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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


@Composable
fun ProjectCreation (projectViewModel: ProjectViewModel = viewModel()){
    val navController = LocalNavController.current
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var imageUrl by rememberSaveable { mutableStateOf("") }

    MainLayout(
        screenTitle = "Add Project"
    ) {
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            OutlinedTextField(
                value = title,
                onValueChange = {title = it},
                label = {Text("Title")},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = description,
                onValueChange = {description = it},
                label = { Text("Description")},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = imageUrl,
                onValueChange = {imageUrl = it},
                label = { Text("Image Url link")},
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (title.isNotBlank()){
                        title = ""
                        description = ""
                        imageUrl = ""
                        navController.navigate("DetailRoute")
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectCreationPreview() = PreviewManager { ProjectCreation () }