package com.example.compasscourse.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compasscourse.R
import com.example.compasscourse.model.AuthViewModel
import com.example.compasscourse.ui.theme.Route
@Composable
fun LoginView(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF008CFC) // Sky blue color
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF008EFF),
                            Color(0xFFF3D63C)
                        ) // Sky blue to yellow gradient
                    )
                )
        ) {
            // Background image with faded effect
            Image(
                painter = painterResource(id = R.drawable.bisu), // Replace with your image resource
                contentDescription = "BISU Logo",
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(alpha = 0.3f),
                contentScale = ContentScale.Crop
            )

            // Centered content with text fields and button
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // App Logo above the text fields
                Image(
                    painter = painterResource(id = R.drawable.compasslog), // Replace with your app logo image resource
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(200.dp) // Adjust the size of the logo
                        .padding(bottom = 24.dp) // Space between logo and text fields
                )

                // Email TextField
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it },
                    label = {
                        Text("Email") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    singleLine = true,
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Password TextField
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it },
                    label = {
                        Text("Password") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Log In Button
                Button(
                    onClick = { navController.navigate(Route.AdminView)

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E88E5)
                    ),
                    shape = CircleShape,
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text(text = "Log In", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}
