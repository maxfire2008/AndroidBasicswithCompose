package net.maxstuff.androidbasicswithcompose.practicecomposebasics.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.maxstuff.androidbasicswithcompose.practicecomposebasics.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TasksCompleted(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TasksCompleted(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        Image(
            painter = image,
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "All tasks completed", fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp,
                )
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TasksCompletedPreview() {
    TaskManagerTheme {
        TasksCompleted()
    }
}