package com.example.projectmanagerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.projectmanagerapp.data.Project
import com.example.projectmanagerapp.ui.components.MainLayout
import com.example.projectmanagerapp.ui.preview.PreviewManager

/**
 * Project detail screen.
 *
 * Displays detailed information about a selected [Project],
 * including its title, description, and image.
 * @param project The [Project] details are displayed
 */
@Composable
fun ProjectDetail(project : Project){
    MainLayout(
        screenTitle = "Project Detail"
    ) {
        Card(
            modifier = Modifier.padding(20.dp),
            shape = MaterialTheme.shapes.large
        ){
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                // display project title
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.padding(15.dp))

                // display project description
                Text (
                    text = project.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(8.dp)
                )

                //  display project image
                AsyncImage(
                    model = project.imageUrl,
                    contentDescription = "Project Image",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProjectDetailReview() {
    PreviewManager {
        ProjectDetail(
            project = Project(
                projectId = 1,
                title = "Sample title",
                description = "Sample description",
                imageUrl = ""
            )
        )
    }
}

