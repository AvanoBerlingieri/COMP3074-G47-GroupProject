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
import capstone.safeline.models.ChatUser
import capstone.safeline.ui.components.BottomNavBar
import capstone.safeline.ui.components.ChatCard
import capstone.safeline.ui.components.TopBar

class Chat : ComponentActivity() {

    private val chatUsers = listOf(
        ChatUser("John Doe", "Hey, how are you?", "12:30 PM"),
        ChatUser("Jane Smith", "Meeting at 2 PM", "11:45 AM"),
        ChatUser("Mike Lee", "Call me back!", "10:20 AM"),
        ChatUser("Jeff", "I might be too cool", "12:00 PM"),
        ChatUser("Savs", "gymnastics is at 3", "2:00 PM"),
        ChatUser("Avano", "Dude we are cooked!!!", "11:50 PM"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatScreen(
                chatUsers = chatUsers,
                onSendClick = {
                    // TODO
                },
                onUserClick = { user ->
                    val intent = Intent(this, Chat::class.java)
                    intent.putExtra("userName", user.name)
                    startActivity(intent)
                },
                onNavigate = { destination ->
                    when (destination) {
                        "home" -> startActivity(Intent(this, Home::class.java))
                        "calls" -> startActivity(Intent(this, Call::class.java))
                        "messages" -> {}
                        "profile" -> startActivity(Intent(this, Profile::class.java))
                    }
                }
            )
        }
    }
}

@Composable
fun ChatScreen(
    chatUsers: List<ChatUser>,
    onSendClick: () -> Unit,
    onUserClick: (ChatUser) -> Unit,
    onNavigate: (String) -> Unit
) {
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF0B0014), Color(0xFF0D2244))
    )

    Scaffold(
        topBar = { TopBar(title = "Chats") },
        bottomBar = {
            BottomNavBar(
                currentScreen = "messages",
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
                    onClick = onSendClick,
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
                    Text("Send a message", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(chatUsers) { user ->
                        ChatCard(user = user, onClick = onUserClick)
                    }
                }
            }
        }
    }
}
