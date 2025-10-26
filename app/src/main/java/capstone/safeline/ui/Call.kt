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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import capstone.safeline.models.CallEntry
import capstone.safeline.ui.components.BottomNavBar
import capstone.safeline.ui.components.CallCard
import capstone.safeline.ui.components.TopBar

class Call : ComponentActivity() {

    private val callLog = listOf(
        CallEntry("John Doe", "Incoming", "12:30 PM"),
        CallEntry("Jane Smith", "Missed", "11:45 AM"),
        CallEntry("Mike Lee", "Missed", "10:20 AM"),
        CallEntry("Avano", "Missed", "5:00 PM"),
        CallEntry("Nima", "Missed", "7:00 AM"),
        CallEntry("Lhek", "Missed", "10:00 PM")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CallScreen(
                callLog = callLog,
                onMakeCallClick = {
                    // TODO
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
    callLog: List<CallEntry>,
    onMakeCallClick: () -> Unit,
    onNavigate: (String) -> Unit
) {
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF0B0014), Color(0xFF0D2244))
    )

    Scaffold(
        topBar = { TopBar(title = "Calls")},
        bottomBar = {
            BottomNavBar(
                currentScreen = "calls",
                onNavigate = onNavigate
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush)
                .padding(innerPadding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(30.dp))

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

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {items(callLog) { call ->
                    CallCard(call = call, onClick = {/* TODO */})
                }
                }
            }
        }
    }
}
