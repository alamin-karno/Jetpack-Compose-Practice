package com.alaminkarno.composequadrant


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaminkarno.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}



@Composable
fun ComposeCard(
    title: String,
    message:String,
    bgColor: Color,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify,
        )
    }
}


@Composable
fun ComposeQuadrant(){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposeCard(
                title = stringResource(R.string.first_title),
                message = stringResource(R.string.first_message),
                bgColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                title = stringResource(R.string.second_title),
                message = stringResource(R.string.second_messge),
                bgColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposeCard(
                title = stringResource(R.string.third_title),
                message = stringResource(R.string.third_message),
                bgColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                title = stringResource(R.string.fourth_title),
                message = stringResource(R.string.fourth_message),
                bgColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrant()
    }
}