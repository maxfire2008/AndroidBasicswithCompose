package net.maxstuff.androidbasicswithcompose.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.maxstuff.androidbasicswithcompose.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.pfp)
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = image,
                contentDescription = "Max's profile picture",
                alignment = Alignment.Center,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Text(
                stringResource(R.string.full_name),
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 1.dp)
                    .fillMaxWidth(),
            )
            Text(
                stringResource(R.string.job_title),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp)
        ) {
            ContactMethod(
                icon = Icons.Rounded.Phone,
                methodName = "Phone",
                methodValue = "+1 (555) 321 503"
            )
            ContactMethod(
                icon = Icons.Rounded.Email,
                methodName = "Email",
                methodValue = "john@example.com"
            )
        }
    }
}

@Composable
private fun ContactMethod(icon: ImageVector, methodName: String, methodValue: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Icon(
            icon,
            contentDescription = methodName,
            modifier = Modifier.padding(start = 50.dp, end = 10.dp)
        )
        Text(methodValue, modifier = Modifier.width(200.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}