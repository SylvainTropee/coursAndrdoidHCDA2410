package com.example.mod3demo5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod3demo5.ui.theme.CoursAndroidHCDA2410Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursAndroidHCDA2410Theme {
                ArticleList()
            }
        }
    }
}

@Composable
fun ArticleList(modifier: Modifier = Modifier) {

    val articles = List(100){
        "Article $it"
    }

    LazyColumn() {
        items(articles){
            ArticleItem(name = it)
        }
    }


}


@Composable
fun ArticleItem(
    name : String,
    modifier: Modifier = Modifier
) {

    var isChecked = false

    Surface(
        border = BorderStroke(2.dp, Color.Blue),
        shape = CircleShape,
      //  color = MaterialTheme.colorScheme.tertiary
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = name)
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                }
            )
        }
    }

}

@Preview
@Composable
private fun Preview() {
    ArticleList()
}

