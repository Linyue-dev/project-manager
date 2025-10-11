package com.example.projectmanagerapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.projectmanagerapp.routes.LocalNavController
import com.example.projectmanagerapp.routes.Router
import com.example.projectmanagerapp.routes.Routes

/**
 * Main layout wrapper for all screens.
 * Provides a shared top bar, bottom navigation bar, and optional snackbar host.
 * Accepts composable content for the main screen body.
 * @param screenTitle Title displayed in the top bar.
 * @param snackbarHostState Optional Snackbar host for showing messages.
 * @param content Main screen content.
 */
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

/**
 * Shared top bar.
 *
 * Displays the current screen title and a back button if navigation history exists.
 * Includes a placeholder menu icon on the right.
 * @param screenTitle Title displayed in the center of the top app bar.
 */
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

/**
 * Shared bottom navigation bar.
 *
 *  Provides quick navigation between key screens:
 *  - About
 *  - Add Project
 *  - Project Library
 *  - Profile/About - for future exploitation
 */
@Composable
fun SharedBottomBar() {
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
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
                    imageVector = if (currentRoute == Routes.About.routes)
                        Icons.Filled.Home
                    else
                        Icons.Outlined.Home,
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
                    imageVector = if (currentRoute == Routes.AddProject.routes)
                        Icons.Filled.Add
                    else
                        Icons.Outlined.Add,
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
                    imageVector = if (currentRoute == Routes.ProjectLibrary.routes)
                        Icons.Filled.Archive
                    else
                        Icons.Outlined.Archive,
                    contentDescription = "Project List",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            IconButton(
                onClick = {navController.navigate(Routes.Profile.routes)}
            ) {
                Icon(
                    imageVector = if (currentRoute == Routes.Profile.routes)
                        Icons.Filled.Person
                    else
                        Icons.Outlined.Person,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}