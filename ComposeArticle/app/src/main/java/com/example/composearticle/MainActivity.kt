package com.example.composearticle


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleImage(getString(R.string.title_text),getString(R.string.short_description_text),getString(R.string.full_description_text))
                }
            }
        }
    }
}

@Composable
fun Article(title: String,shortDescription: String,fullDescription: String) {
    Column {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),
        )
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),

        )
        Text(
            text = fullDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ComposeArticleImage(title: String,shortDescription: String,fullDescription: String,modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Article(
            title = title,
            shortDescription= shortDescription,
            fullDescription = fullDescription,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        ComposeArticleImage(stringResource(R.string.title_text),stringResource(R.string.short_description_text),stringResource(R.string.full_description_text))
    }
}