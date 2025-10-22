package capstone.safeline.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavBar(
    currentScreen: String,
    onNavigate: (String) -> Unit
) {
    BottomAppBar(
        containerColor = Color(0xFF0D2244),
        contentColor = Color.White,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { onNavigate("home") }) {
            Icon(
                Icons.Filled.Home,
                contentDescription = "Home",
                tint = if (currentScreen == "home") Color(0xFFFF0066) else Color.White
            )
        }
        IconButton(onClick = { onNavigate("calls") }) {
            Icon(
                Icons.Filled.Call,
                contentDescription = "Calls",
                tint = if (currentScreen == "calls") Color(0xFFFF0066) else Color.White
            )
        }
        IconButton(onClick = { onNavigate("messages") }) {
            Icon(
                Icons.Filled.MailOutline,
                contentDescription = "Messages",
                tint = if (currentScreen == "messages") Color(0xFFFF0066) else Color.White
            )
        }
        IconButton(onClick = { onNavigate("profile") }) {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Profile",
                tint = if (currentScreen == "profile") Color(0xFFFF0066) else Color.White
            )
        }
    }
}
