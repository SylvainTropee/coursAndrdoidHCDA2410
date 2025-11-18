package com.example.mod5demo5

import androidx.navigation.NavType
import androidx.navigation.navArgument

object LoginDestination{
    val route: String = "login"
}

object HomeDestination {
    val route : String = "home"

    val argName = "loginValue"

    val args = listOf(
        navArgument(argName){
            type = NavType.StringType
        }
    )

    val routeWithArgs = "$route/{$argName}"

}