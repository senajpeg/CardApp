package com.senaaksoy.createbusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.senaaksoy.createbusinesscard.ui.theme.CreateBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MakeLogoAndInfo(
                        fullName = "SENA AKSOY",
                        title = "Android Developer",
                        tellNumber = "05071931424",
                        accountName = "@19sena07",
                        contact = "sena04176@gmail.com",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MakeLogoAndInfo(
    fullName: String,
    title: String,
    tellNumber: String,
    accountName: String,
    contact: String,
    modifier: Modifier = Modifier
) {
    var image = painterResource(R.drawable.android_logo)
    val opaqueLightGreen = Color(0xFF90EE90).copy(alpha = 0.5f)
    Column(
        modifier = modifier
            .background(opaqueLightGreen)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Box(modifier = Modifier
            .padding(8.dp)
            .background(Color.DarkGray)) {
            Image(painter = image, contentDescription = null, modifier = modifier.height(120.dp))
        }
        Text(
            text = fullName, fontSize = 50.sp,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            ), textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            color = Color(0xFF008000),
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = modifier, verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.call),
                    contentDescription = "get contact",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 8.dp),
                    tint = Color(0xFF556B2F)
                )
                Text(text = tellNumber)

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.mail),
                    contentDescription = "e-mail",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 8.dp),
                    tint = Color(0xFF556B2F)
                )
                Text(text = contact)
            }
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    painter = painterResource(id = R.drawable.share),
                    contentDescription = "Account",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 8.dp),
                    tint = Color(0xFF556B2F)
                )
                Text(text = accountName)
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun CreateBusinessCardPreview() {
    CreateBusinessCardTheme {
        MakeLogoAndInfo(
            fullName = "SENA AKSOY",
            title = "Android Developer",
            tellNumber = "05071931424",
            accountName = "@19sena07",
            contact = "sena04176@gmail.com"
        )
    }
}