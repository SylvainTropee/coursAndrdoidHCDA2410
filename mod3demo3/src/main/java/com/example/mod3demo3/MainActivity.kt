package com.example.mod3demo3


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod3demo3.ui.theme.CoursAndroidHCDA2410Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidHCDA2410Theme {
                ColumnAndRowExample(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun ColumnAndRowExample(modifier: Modifier = Modifier) {

    Column() {
        Text("Exemple pour row et column")
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Item A")
            Text("Item B")
            Text("Item C")
        }
    }
}

@Composable
fun BoxExample(modifier: Modifier = Modifier) {

    Box(
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(R.drawable.compose_man),
            contentDescription = "Compose man"
        )
        Icon(
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = null,
            tint = Color.Red
        )
    }


}



@Preview
@Composable
private fun Preview() {
    //ColumnAndRowExample(modifier = Modifier.fillMaxWidth())
    BoxExample()
}