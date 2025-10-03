package com.example.projectmanagerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectmanagerapp.routes.Router
import com.example.projectmanagerapp.ui.theme.ProjectManagerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectManagerAppTheme {
                Router()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RouterPreview(){
    ProjectManagerAppTheme {
        Router()
    }
}