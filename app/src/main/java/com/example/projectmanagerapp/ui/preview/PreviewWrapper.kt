package com.example.projectmanagerapp.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.example.projectmanagerapp.routes.LocalNavController
import com.example.projectmanagerapp.ui.theme.ProjectManagerAppTheme

@Composable
fun PreviewManager(content : @Composable () -> Unit){
    val mockController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides mockController) {
        ProjectManagerAppTheme {
            content()
        }
    }
}

