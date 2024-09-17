package com.example.jetpackcomposetutorial

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    private val context: Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                JetpackTutorial(
                    context,
                    context.getString(R.string.heading),
                    context.getString(R.string.sub_heading),
                    context.getString(R.string.content)
                )
            }
        }
    }
}

@Composable
fun JetpackTutorial(
    context: Context,
    headline: String,
    subHeadline: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "HeadImage"
        )

        Text(
            text = context.getString(R.string.heading),
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = context.getString(R.string.sub_heading),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = context.getString(R.string.content),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun JetpackTutorialPreview() {
    val context = LocalContext.current
    JetpackComposeTutorialTheme {
        JetpackTutorial(
            context,
            context.getString(R.string.heading),
            context.getString(R.string.sub_heading),
            context.getString(R.string.content)
        )
    }
}