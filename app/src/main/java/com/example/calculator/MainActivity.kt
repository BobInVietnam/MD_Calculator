package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Calculator()
            }
        }
    }
}

class CalculatorModel() {
    var calcResult = 0
    var calcString = "0"

    fun updateString(string: String) {
        calcString += string
    }
    fun clearAll() {
        calcString = "0"
        calcResult = 0
    }
    fun clearOne() {
        calcString.dropLast(1)
    }
    fun calculate() {

    }
}

@Composable
fun Calculator() {
    val calculator = CalculatorModel()
    var CalcResult by remember { mutableStateOf(calculator.calcResult.toString()) }
    var CalcString by remember { mutableStateOf(calculator.calcString) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(CalcString

            )
            Text(CalcResult

            )
        }

        Column(
            modifier = Modifier.weight(1f).fillMaxSize()
        ) {
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {},
                    colors = ButtonColors(
                        contentColor = Color(255, 180, 180),
                        disabledContainerColor = Color(255, 180, 180),
                        disabledContentColor = Color(255, 180, 180),
                        containerColor = Color(255, 180, 180)
                    )
                    ) {
                    Text("C")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("del")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("%")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 100))
                ) {
                    Text("/")
                }
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(255, 164, 164))
                ) {
                    Text("C")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("del")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("%")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 100))
                ) {
                    Text("/")
                }
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(255, 164, 164))
                ) {
                    Text("C")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("del")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("%")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 100))
                ) {
                    Text("/")
                }
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(255, 164, 164))
                ) {
                    Text("C")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("del")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("%")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 100))
                ) {
                    Text("/")
                }
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(255, 164, 164))
                ) {
                    Text("C")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("del")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 200))
                ) {
                    Text("%")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.background(Color(200, 200, 100))
                ) {
                    Text("/")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Calculator()
    }
}