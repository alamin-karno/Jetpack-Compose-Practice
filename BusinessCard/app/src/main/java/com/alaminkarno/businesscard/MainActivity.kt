package com.alaminkarno.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.alaminkarno.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyInfoCard(
            name = stringResource(R.string.name_text),
            designation = stringResource(R.string.designation_text)
        )
        ContactInfo()
    }
}

@Composable
fun MyInfoCard(name: String,designation:String){
    val image = rememberAsyncImagePainter(stringResource(R.string.image_link))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = name,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = designation,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0A6F37),

        )
    }

}

@Composable
fun ContactInfo(){
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.padding(top = 50.dp)
    ) {
        ContactRow(
            icon = Icons.Filled.Call,
            description = "Call",
            title = "+880162183919"
        )
        ContactRow(
            icon = Icons.Filled.Share,
            description = "Share",
            title = "@alamin.karno"
        )
        ContactRow(
            icon = Icons.Filled.Email,
            description = "Email",
            title = "alamin.karno@outlook.com"
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, description:String, title:String){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(bottom = 10.dp)
    ){
        Icon(
            icon,
            contentDescription = description,
            tint = Color(0xFF2C4738),
        )
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color(0xFF2C4738),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}