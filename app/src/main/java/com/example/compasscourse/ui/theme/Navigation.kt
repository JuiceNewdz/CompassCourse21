package com.example.compasscourse.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.compasscourse.model.AuthViewModel
import com.example.compasscourse.view.AdminView
import com.example.compasscourse.view.AdmissionTestView
import com.example.compasscourse.view.GetStarted
import com.example.compasscourse.view.LoginView
import com.example.compasscourse.view.OverView
import com.example.compasscourse.view.ProgramOffersView
import com.example.compasscourse.view.RegisterView

@Composable
fun Navigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    // Initialize the NavController
    val navController = rememberNavController()

    // Set up NavHost with a start destination
    NavHost(navController = navController, startDestination = Route.ProgramOffers){
        // Define each destination
        composable(Route.GetStarted) {
            GetStarted(modifier, navController, authViewModel)
        }
        // Add other screens as needed, e.g., "home", "details", etc.
        composable(Route.ProgramOffers) {
            ProgramOffersView(modifier, navController, authViewModel)
        }
        composable(Route.TestView) {
            AdmissionTestView(modifier, navController, authViewModel)
        }
        composable(Route.AdminView) {
            AdminView(modifier, navController, authViewModel, isAdmin = true)
        }
        composable(Route.OverView) {
            OverView(navController,authViewModel)
        }
        composable(Route.LoginView) {
            LoginView(modifier, navController, authViewModel)
        }
        composable(Route.RegisterView) {
            RegisterView(modifier, navController, authViewModel)
        }
    }

}

// Sample composable screen
