package net.maxstuff.androidbasicswithcompose.practicecomposebasics.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.maxstuff.androidbasicswithcompose.practicecomposebasics.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quadrants(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, modifier: Modifier = Modifier) {
    Text(
        title
    )
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Column (
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = "test",
                description = "hellosafd",
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "test",
                description = "hellosafd",
                modifier = Modifier.weight(1f)
            )
        }
        Column (
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = "test",
                description = "hellosafd",
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = "test",
                description = "hellosafd",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    ComposeQuadrantTheme {
        Quadrants()
    }
}