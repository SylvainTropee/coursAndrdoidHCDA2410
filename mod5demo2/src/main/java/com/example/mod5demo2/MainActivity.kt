package com.example.mod5demo2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.example.mod5demo2.ui.theme.CoursAndroidHCDA2410Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidHCDA2410Theme {
                GoToMap()
            }
        }
    }
}

@Composable
fun GoToMap(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Button(
        onClick = {
            Intent(Intent.ACTION_VIEW, "geo:47.22592432240718, -1.6178542077703035".toUri()).also {
                context.startActivity(it)
            }
        }
    ) {
        Text("GO !")
    }

}