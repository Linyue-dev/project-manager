package com.example.projectmanagerapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectmanagerapp.data.Project
import com.example.projectmanagerapp.routes.MainLayout
import com.example.projectmanagerapp.ui.preview.PreviewManager

@Composable
fun ProjectDetail(project : Project){
    MainLayout(
        screenTitle = "Project Detail"
    ) {
        Card(
            modifier = Modifier.padding(10.dp)
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(project.title)
                Text (project.description)
                Text(project.imageUrl)
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