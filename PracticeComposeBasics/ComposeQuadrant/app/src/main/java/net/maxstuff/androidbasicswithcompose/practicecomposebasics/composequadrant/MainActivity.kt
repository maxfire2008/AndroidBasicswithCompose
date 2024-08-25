package net.maxstuff.androidbasicswithcompose.practicecomposebasics.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun Quadrant(title: String, description: String, color: Color, modifier: Modifier = Modifier) {
    Box(modifier = modifier.background(color = color)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                title,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                description,
                textAlign = TextAlign.Justify,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

    }
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant_1_title),
                description = stringResource(R.string.quadrant_1_description),
                color = colorResource(R.color.quadrant_1),
                modifier = Modifier.weight(1f),
            )
            Quadrant(
                title = stringResource(R.string.quadrant_2_title),
                description = stringResource(R.string.quadrant_2_description),
                color = colorResource(R.color.quadrant_2),
                modifier = Modifier.weight(1f),
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                title = stringResource(R.string.quadrant_3_title),
                description = stringResource(R.string.quadrant_3_description),
                color = colorResource(R.color.quadrant_3),
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = stringResource(R.string.quadrant_4_title),
                description = stringResource(R.string.quadrant_4_description),
                color = colorResource(R.color.quadrant_4),
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