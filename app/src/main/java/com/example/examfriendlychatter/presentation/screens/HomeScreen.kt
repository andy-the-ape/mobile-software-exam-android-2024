package com.example.examfriendlychatter.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.examfriendlychatter.data.ChatRoom

@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    val chatRooms = remember {
        listOf(
            ChatRoom("1", "General"),
            ChatRoom("2", "Random"),
            ChatRoom("3", "Study Group")
        )
    }

    Column(modifier = Modifier.padding(16.dp)) {
        chatRooms.forEach { chatRoom ->
            Text(
                text = chatRoom.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("chatRoom/${chatRoom.id}")
                    }
                    .padding(8.dp)
            )
        }
    }
}