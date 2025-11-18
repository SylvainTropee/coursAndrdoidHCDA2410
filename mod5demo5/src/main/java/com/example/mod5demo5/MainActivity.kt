package com.example.mod5demo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mod5demo5.ui.theme.CoursAndroidHCDA2410Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidHCDA2410Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navHostController,
        startDestination = LoginDestination.route
    ){
        composable(route = LoginDestination.route){
            LoginPage(onClickToHome = {
                navHostController.navigate("${HomeDestination.route}/$it")
            })
        }
        composable(
            route = HomeDestination.routeWithArgs,
            arguments = HomeDestination.args
        ){navBackStackEntry ->
            val loginValue = navBackStackEntry.arguments?.getString(HomeDestination.argName) ?: "Michel"
            HomePage(loginValue = loginValue)
        }
    }
}

@Composable
fun LoginPage(
    onClickToHome : (String) -> Unit,
    modifier: Modifier = Modifier) {

    var loginValue by remember { mutableStateOf("") }

    Column() {
        TextField(
            value = loginValue,
            onValueChange = {
                loginValue = it
            },
            label = { Text("Login ?") }
        )
        OutlinedButton(
            onClick = { onClickToHome(loginValue) }
        ) {
            Text("Se connecter")
        }
    }

}

@Composable
fun HomePage(
    loginValue : String,
    modifier: Modifier = Modifier) {
    Column() {
        Text("Hello $loginValue !")
    }
}