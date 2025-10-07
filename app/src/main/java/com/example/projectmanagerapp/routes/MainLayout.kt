package com.example.projectmanagerapp.routes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainLayout(
    screenTitle : String,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    content: @Composable () -> Unit
){
    Scaffold (
        topBar = {SharedTopBar(screenTitle)},
        bottomBar = { SharedBottomBar()},
        snackbarHost = { SnackbarHost(hostState = snackbarHostState)}
    ){
        Column(
            modifier = Modifier.padding(it),
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTopBar(screenTitle : String) {
    val navController = LocalNavController.current
    CenterAlignedTopAppBar(
        title =
            {
                Text(
                    text = screenTitle,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            },
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

    BottomAppBar {
        Row (
            modifier = Modifier.padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(
                onClick = {navController.navigate(Routes.About.routes)}
            ) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "About",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = {navController.navigate(Routes.AddProject.routes)}
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add Project",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = {navController.navigate(Routes.ProjectLibrary.routes)}
            ) {
                Icon(
                    imageVector = Icons.Outlined.Archive,
                    contentDescription = "Project List",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = {navController.navigate(Routes.About.routes)}
            ) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "About",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}