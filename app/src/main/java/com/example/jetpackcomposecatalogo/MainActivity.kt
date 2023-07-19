package com.example.jetpackcomposecatalogo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        MyButtonExample()

                    }


                }
            }
        }
    }
}

@Composable
fun MyStateExample() {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }


    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")

        }
        Text(text = "He sido Pulsado $counter veces")

    }

}


@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")

        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")

            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            )
            {
                Text(text = "Ejemplo 3")


            }

        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")

        }

    }
}


@Composable
fun MyRow() {
    Row() {
        Text(text = "Emjemplo1")
        Text(text = "Emjemplo2")
        Text(text = "Emjemplo3")

    }
}


@Composable
fun MyColumn() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Ejemplo1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Ejemplo2", modifier = Modifier.background(Color.Green))
        Text(text = "Ejemplo3", modifier = Modifier.background(Color.Blue))
        Text(text = "Ejemplo4", modifier = Modifier.background(Color.Red))


    }

}


@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Esto es un ejemplo")
        }


    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoTheme {
        MyButtonExample()
    }
}


@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo 1")
        Text(text = "Esto es un ejemplo 2", color = Color.Gray)
        Text(text = "Esto es un ejemplo 3", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo 4", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo 5",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(text = "Esto es un ejemplo 6", fontSize = 30.sp)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(name: String, onValueChange: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChange(it) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it },
        label = { Text(text = "Introduce tu nombre") })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Hola") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Gray
        )
    )

}

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable {
        mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(contentColor = Color.Blue),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")

        }
        OutlinedButton(
            onClick = { enabled = false},
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(contentColor = Color.Blue,
            disabledContainerColor = Color.Red, disabledContentColor = Color.Yellow),
            border = BorderStroke(5.dp, Color.Green),
        ) {
            Text(text = "Hola")

        }

    }
}

