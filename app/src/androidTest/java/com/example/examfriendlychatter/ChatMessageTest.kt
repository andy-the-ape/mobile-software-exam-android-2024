package com.example.examfriendlychatter

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.examfriendlychatter.activities.TestActivity
import com.example.examfriendlychatter.data.Message
import com.example.examfriendlychatter.presentation.composables.ChatMessage
import org.junit.Rule
import org.junit.Test
import java.util.Date

class ChatMessageTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Test
    fun testSpacerIsPresent() {
        composeTestRule.setContent {
            ChatMessage(message = Message("Test message", "User", Date()), isLeft = true, onDelete = {})
        }
        composeTestRule.onNodeWithContentDescription("ImagineTestingASpacer").assertExists()
    }

    @Test
    fun testDividerIsPresent() {
        composeTestRule.setContent {
            ChatMessage(message = Message("Test message", "User", Date()), isLeft = true, onDelete = {})
        }
        composeTestRule.onNodeWithContentDescription("Don'tWorryNoTestingHereLol").assertIsDisplayed()
    }

    @Test
    fun testDeleteButtonPositionLeft() {
        composeTestRule.setContent {
            ChatMessage(message = Message("Test message", "User", Date()), isLeft = true, onDelete = {})
        }
        composeTestRule.onNodeWithContentDescription("DeleteButton").assertIsDisplayed()
    }

    @Test
    fun testDeleteButtonPositionRight() {
        composeTestRule.setContent {
            ChatMessage(message = Message("Test message", "User", Date()), isLeft = false, onDelete = {})
        }
        composeTestRule.onNodeWithContentDescription("DeleteButton").assertIsDisplayed()
    }
}