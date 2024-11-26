package com.example.compasscourse.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compasscourse.R
import com.example.compasscourse.model.AuthViewModel
import com.example.compasscourse.ui.theme.Route

data class FloatingButtonData(
    val iconResId: Int,
    val text: String,
    val backgroundColor: Color,
    val textColor: Color
)

@Composable
fun ProgramOffersView(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel) {
    var selectedProgram by remember { mutableStateOf<FloatingButtonData?>(null) }

    val buttons = listOf(
        FloatingButtonData(R.drawable.cs, "Bachelor of Science in Computer Science", Color(0xFFA00A0F), Color.White),
        FloatingButtonData(R.drawable.bisu, "Bachelor of Elementary Education", Color(0xFF05A8F3), Color.White),
        FloatingButtonData(R.drawable.bisu, "Bachelor of Science in Hospitality Management", Color(0xFF0AB9EE), Color.White),
        FloatingButtonData(R.drawable.bisu, "Bachelor of Science in Environmental Science", Color(0xFF06F026), Color.White),
        FloatingButtonData(R.drawable.bisu, "Bachelor in Secondary Education major in Mathematics", Color(0xFF0440F1), Color.White),
        FloatingButtonData(R.drawable.bisu, "Bachelor in Technology Education major in Home Economics", Color(0xFFFF5722), Color.White),
        FloatingButtonData(R.drawable.bisu, "Master of Arts in Education major in Education Management", Color(0xFF6200EE), Color.White)
    )

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFF008CFC) // Sky blue background color
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF008EFF),
                            Color(0xFFF3D63C)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            // Background image
            Image(
                painter = painterResource(id = R.drawable.bisu),
                contentDescription = "BISU Logo",
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(alpha = 0.3f),
                contentScale = ContentScale.Crop
            )

            if (selectedProgram == null) {
                // Main view with grid of buttons (2 columns)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 16.dp)
                ) {
                    // Title
                    Text(
                        text = "Bachelor's Programs Offered:",
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, bottom = 16.dp),
                        fontSize = 24.sp,
                        textAlign = TextAlign.Start
                    )

                    // LazyVerticalGrid for two lines (2 columns)
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(buttons) { buttonData ->
                            FloatingButton(buttonData, onClick = {
                                selectedProgram = buttonData
                            })
                        }
                    }
                }
            } else {
                DetailedProgramCard(selectedProgram!!) {
                    selectedProgram = null
                }
            }

            // Bottom buttons
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { navController.navigate(Route.LoginView) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text("Continue as Admin", color = Color.Black, fontSize = 12.sp)
                }
                Button(
                    onClick = { navController.navigate(Route.TestView) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text("Next", color = Color.Black, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun FloatingButton(buttonData: FloatingButtonData, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth() // Each button takes full width of the column
            .height(300.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonData.backgroundColor)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = buttonData.iconResId),
                contentDescription = buttonData.text,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = buttonData.text,
                color = buttonData.textColor,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                maxLines = 2
            )
        }
    }
}

@Composable
fun DetailedProgramCard(program: FloatingButtonData, onBackClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(360.dp)
                .height(350.dp)
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = program.backgroundColor)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize() // Ensure the Column takes up the full height of the Card
                    .padding(24.dp) // Increased padding for better spacing
            ) {
                Image(
                    painter = painterResource(id = program.iconResId),
                    contentDescription = program.text,
                    modifier = Modifier.size(100.dp) // Increased size for the icon
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = program.text,
                    color = Color.White,
                    fontSize = 20.sp, // Slightly larger font size
                    textAlign = TextAlign.Center,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = when (program.text) {
                        "Bachelor of Science in Computer Science" ->
                            "Focuses on software development, algorithms, and system design."
                        "Bachelor of Elementary Education" ->
                            "Prepares students to teach at the elementary level with a focus on child development."
                        "Bachelor of Science in Hospitality Management" ->
                            "Develops skills for careers in hotel management, event planning, and tourism."
                        else -> "Program details coming soon."
                    },
                    color = Color.White,
                    fontSize = 16.sp, // Larger font for the description
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(

                    onClick = onBackClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(text = "Back", color = Color.Black)
                }
            }
        }
    }
}
