package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                        LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp()
{
    var currentStep by remember{ mutableStateOf(1)}

    Surface(modifier = Modifier.fillMaxSize(),color=MaterialTheme.colors.background)
    {
        when(currentStep)
        {
            1->{
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize())
                {
                    Text(text = stringResource(R.string.LemonTree))
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(painter = painterResource(id = R.drawable.lemontree), contentDescription = stringResource(R.string.LemonTree), modifier = Modifier
                        .wrapContentSize()
                        .clickable { currentStep = 2 }.border(
                            BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(16.dp))
                }
            }
            2->{
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize())
                {
                    Text(text = stringResource(id = R.string.Lemon))
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(painter = painterResource(id = R.drawable.lemon), contentDescription = stringResource(id = R.string.Lemon),modifier= Modifier
                        .wrapContentSize()
                        .clickable { currentStep = 3 }.border(
                        BorderStroke(2.dp, Color(105, 205, 216)),
                        shape = RoundedCornerShape(4.dp)
                    )
                        .padding(16.dp)
                    )
                }
            }
            3->{
                Column(horizontalAlignment =Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize() ) {
                    Text(text = stringResource(id = R.string.GlassOfLemonade))
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(painter = painterResource(id = R.drawable.lemondrink), contentDescription = stringResource(
                        id = R.string.GlassOfLemonade),modifier= Modifier
                        .wrapContentSize()
                        .clickable { currentStep = 4 }.border(
                            BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(16.dp)
                    )
                }
            }
            
            4->{
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
                    Text(text = stringResource(id = R.string.EmptyGlass))
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(painter = painterResource(id = R.drawable.emptyglass), contentDescription = stringResource(
                        id = R.string.EmptyGlass), modifier = Modifier.wrapContentSize().clickable { currentStep= 1}.border(
                        BorderStroke(2.dp, Color(105, 205, 216)),
                        shape = RoundedCornerShape(4.dp)
                    )
                        .padding(16.dp))
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeAppTheme {
        LemonApp()
    }
}