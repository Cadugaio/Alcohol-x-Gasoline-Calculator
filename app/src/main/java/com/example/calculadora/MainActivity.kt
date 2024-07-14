package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ContentView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                Content()
            }
        }
    }
}


@Composable
fun Content(modifier: Modifier = Modifier) {
    //ctrl P - ver o que da pra ter
    //ctrl alt L - formatar
    //
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculator",
            color = Color.Black
        )

        val gasolina = remember {
            mutableStateOf(0f)
        }
        Text(text = "Gasolina ${gasolina.value}")
        TextField(
            value = gasolina.value.toString(),
            onValueChange = { gasolina.value = it.toFloat() }
        )

        val alcool = remember {
            mutableStateOf(0f)
        }
        Text(text = "Álcool ${alcool.value}")
        TextField(
            value = alcool.value.toString(),
            onValueChange = { alcool.value = it.toFloat() }
        )

        var result = alcool.value/gasolina.value


        if (result>0.7){
            Text(text = "Use Gasolina")
        }
        else{
            Text(text = "Use Álcool")

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        Content()
    }
}