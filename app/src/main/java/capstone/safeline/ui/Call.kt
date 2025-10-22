package capstone.safeline.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.safeline.ui.components.BottomNavBar

class Call : ComponentActivity() {

    // sedded data
    private val callLog = listOf(
        "John Doe - Incoming - 12:30 PM",
        "Jane Smith - Outgoing - 11:45 AM",
        "Mike Lee - Missed - 10:20 AM",
        "John Doe - Incoming - 12:30 PM",
        "Jane Smith - Outgoing - 11:45 AM",
        "Mike Lee - Missed - 10:20 AM",
        "John Doe - Incoming - 12:30 PM",
        "Jane Smith - Outgoing - 11:45 AM",
        "Mike Lee - Missed - 10:20 AM",
        "John Doe - Incoming - 12:30 PM",
        "Jane Smith - Outgoing - 11:45 AM",
        "Mike Lee - Missed - 10:20 AM"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CallScreen(
                callLog = callLog,
                onMakeCallClick = {
                    // TODO make call action
                },
                onNavigate = { destination ->
                    when (destination) {
                        "home" -> startActivity(Intent(this, Home::class.java))
                        "calls" -> {}
                        "messages" -> startActivity(Intent(this, Chat::class.java))
                        "profile" -> startActivity(Intent(this, Profile::class.java))
                    }
                }
            )
        }
    }
}

@Composable
fun CallScreen(
    callLog: List<String>,
    onMakeCallClick: () -> Unit,
    onNavigate: (String) -> Unit
) {

    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF0B0014), Color(0xFF0D2244))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
            .padding(bottom = 56.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Button(
                onClick = onMakeCallClick,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color.White),
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp)
            ) {
                Text("Make a Call", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(callLog) { call ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0x33FFFFFF))
                    ) {
                        Text(
                            text = call,
                            color = Color.White,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }

        BottomNavBar(
            currentScreen = "calls",
            onNavigate = onNavigate
        )
    }
}
