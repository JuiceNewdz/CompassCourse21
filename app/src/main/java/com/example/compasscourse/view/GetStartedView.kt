package com.example.compasscourse.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import com.example.compasscourse.R
import com.example.compasscourse.model.AuthViewModel
import com.example.compasscourse.ui.theme.Route

@Composable
fun GetStarted(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF008CFC) // Sky blue color
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF008EFF), Color(0xFFF3D63C)) // Sky blue to yellow
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.offset(y = (-100).dp)
            ) {
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(250.dp)
                )

                // Motto Texts
                Text(
                    text = "Unlock best BISU path,",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = "One Course at a Time.",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        // BISU Logo and campus information
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bisu),
                    contentDescription = "BISU Logo",
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.width(10.dp)) // Add space between logo and text
                Column {
                    Text(
                        text = "BISU - Clarin Campus",
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.ExtraLight
                    )
                    Text(
                        text = "Since 2009",
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.ExtraLight
                    )
                    Text(
                        text = "Pub.Norte, Clarin, Bohol",
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.ExtraLight
                    )
                }
            }
        }

        // "Next" Button on the bottom right
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            IconButton(
                onClick = {
                    // Handle click action for the regular user
                    navController.navigate(Route.OverView)
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(56.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Next",
                    tint = Color.Black
                )
            }
        }
    }
}
