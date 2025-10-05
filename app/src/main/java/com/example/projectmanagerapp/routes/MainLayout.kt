package com.example.projectmanagerapp.routes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainLayout(
    screenTitle : String,
    content: @Composable () -> Unit
){
    Scaffold (
        topBar = {SharedTopBar(screenTitle) },
        bottomBar = { SharedBottomBar()}
    ){
        Column(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTopBar(screenTitle : String) {
    val navController = LocalNavController.current
    CenterAlignedTopAppBar(title = { Text (screenTitle)},
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp()}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Go Back"
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { /* do something */}) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        }
    )
}

@Composable
fun SharedBottomBar() {
    val navController = LocalNavController.current
    BottomAppBar(
        actions = {
            IconButton(
                onClick = {navController.navigate("")}
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            }

            IconButton(
                onClick = {navController.navigate(Routes.AddProject.routes)}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Project"
                )
            }

            IconButton(
                onClick = {navController.navigate(Routes.ProjectLibrary.routes)}
            ) {
                Icon(
                    imageVector = Icons.Default.Inventory,
                    contentDescription = "Project List"
                )
            }

            IconButton(
                onClick = {navController.navigate(Routes.About.routes)}
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "About"
                )
            }
        }
    )
}