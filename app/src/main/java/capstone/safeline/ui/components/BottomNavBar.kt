package capstone.safeline.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavBarItem(
                icon = Icons.Filled.Home,
                label = "Home",
                selected = currentScreen == "home",
                onClick = { onNavigate("home") }
            )
            NavBarItem(
                icon = Icons.Filled.Call,
                label = "Calls",
                selected = currentScreen == "calls",
                onClick = { onNavigate("calls") }
            )
            NavBarItem(
                icon = Icons.Filled.MailOutline,
                label = "Messages",
                selected = currentScreen == "messages",
                onClick = { onNavigate("messages") }
            )
            NavBarItem(
                icon = Icons.Filled.Person,
                label = "Profile",
                selected = currentScreen == "profile",
                onClick = { onNavigate("profile") }
            )
        }
    }
}

@Composable
private fun NavBarItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) Color.Red else Color.White,
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = label,
            fontSize = 14.sp,
            color = if (selected) Color.Red else Color.White
        )
    }
}