package com.example.mod5demo4

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class PasswordFieldTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPasswordTextFieldIsWorking(){

        //setup le composant à tester
        composeTestRule.setContent {
            PasswordTextField()
        }

        //premier test existence de l'input
        composeTestRule.onNodeWithTag("ptf").assertExists("Textfield introuvable")

        //actions
        composeTestRule
            .onNodeWithTag("ptf")
            .performTextInput("1234")

        composeTestRule
            .onNodeWithContentDescription("Show password")
            .assertHasClickAction()
            .performClick()

        composeTestRule
            .onNodeWithTag("ptf")
            .assertTextContains("1234")

        composeTestRule
            .onNodeWithContentDescription("Hide password")
            .assertIsDisplayed()

    }

}