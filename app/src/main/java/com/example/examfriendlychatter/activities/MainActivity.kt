package com.example.examfriendlychatter.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examfriendlychatter.presentation.screens.ChatRoom
import com.example.examfriendlychatter.presentation.screens.HomeScreen
import com.example.examfriendlychatter.presentation.theme.ExamFriendlyChatterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamFriendlyChatterTheme(
                dynamicColor = false
            ) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("chatRoom/{chatRoomId}") { backStackEntry ->
                        val chatRoomId = backStackEntry.arguments?.getString("chatRoomId")
                        ChatRoom(chatRoomId)
                    }
                }
            }
        }
    }
}