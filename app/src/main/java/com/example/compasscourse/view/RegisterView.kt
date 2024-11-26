package com.example.compasscourse.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compasscourse.R
import com.example.compasscourse.model.AuthViewModel
import com.example.compasscourse.ui.theme.Route

@Composable
fun RegisterView(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }

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
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Return",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            Text(
                text = "Register Admin",
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth() // Ensure the text fills the available width
                    .padding(top = 50.dp) // Ensure the text fills the available width
            )

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
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Email TextField
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Password TextField
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Confirm Password TextField
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Register Button
                Button(
                    onClick = {
                        // Add registration logic here (e.g., calling a register function)
                        if (password.text == confirmPassword.text) {
                            // Navigate to the next screen after successful registration
                            navController.navigate(Route.AdminView)
                        } else {
                            // Handle password mismatch error
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E88E5)
                    ),
                    shape = CircleShape,
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text(text = "Register", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}


