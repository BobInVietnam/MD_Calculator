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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        if (calcString == "0") calcString = string
        else calcString += string
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

enum class ButtonStyle {
    RED,
    YELLOW,
    GREEN,
    NEUTRAL
}

@Composable
fun CalculatorButton(symbol: String, style: ButtonStyle, onClick: () -> Unit) {
    val buttonColor = when (style) {
        ButtonStyle.RED -> ButtonColors(
            contentColor = Color(32, 32, 32),
            containerColor = Color(252, 143, 143, 255),
            disabledContentColor = Color(32, 32, 32),
            disabledContainerColor = Color(252, 143, 143, 255)
        )
        ButtonStyle.YELLOW -> ButtonColors(
            contentColor = Color(32, 32, 32),
            containerColor = Color(255, 232, 120),
            disabledContentColor = Color(32, 32, 32),
            disabledContainerColor = Color(255, 232, 120)
        )
        ButtonStyle.GREEN-> ButtonColors(
            contentColor = Color(32, 32, 32),
            containerColor = Color(125, 238, 62, 255),
            disabledContentColor = Color(32, 32, 32),
            disabledContainerColor = Color(125, 238, 62, 255)
        )
        else -> ButtonColors(
            contentColor = Color(32, 32, 32),
            containerColor = Color(197, 197, 197, 255),
            disabledContentColor = Color(32, 32, 32),
            disabledContainerColor = Color(197, 197, 197, 255)
        )
    }
    Button(
        colors = buttonColor,
        onClick = onClick,
        modifier = Modifier.padding(4.dp).width(80.dp).height(60.dp)
    ) {
        Text(
            text = symbol,
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun Calculator() {
    val calculator = CalculatorModel()
    var CalcResult by remember { mutableStateOf(calculator.calcResult.toString()) }
    var CalcString by remember { mutableStateOf(calculator.calcString) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Box(Modifier.height(32.dp).background(Color(255, 232, 120)))
        Column (
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(CalcString,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color(103, 103, 103, 255)
            )
            Spacer(Modifier.height(20.dp))
            Text(CalcResult,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                color = Color(103, 103, 103, 255)
            )
            Spacer(Modifier.height(40.dp))
        }

        Column(
            modifier = Modifier.weight(1f).fillMaxSize()
        ) {
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    symbol = "C",
                    style = ButtonStyle.RED,
                    onClick = {
                        calculator.clearAll();
                    })
                CalculatorButton(
                    symbol = "del",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.clearOne();
                    })
                CalculatorButton(
                    symbol = "%",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("%");
                    })
                CalculatorButton(
                    symbol = "/",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        calculator.updateString("/");
                    })
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    symbol = "7",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("7");
                    })
                CalculatorButton(
                    symbol = "8",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("8");
                    })
                CalculatorButton(
                    symbol = "9",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("9");
                    })
                CalculatorButton(
                    symbol = "X",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        calculator.updateString("*");
                    })
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    symbol = "4",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("4");
                    })
                CalculatorButton(
                    symbol = "5",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("5");
                    })
                CalculatorButton(
                    symbol = "6",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("6");
                    })
                CalculatorButton(
                    symbol = "-",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        calculator.updateString("-");
                    })
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    symbol = "1",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("1");
                    })
                CalculatorButton(
                    symbol = "2",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("2");
                    })
                CalculatorButton(
                    symbol = "3",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("3");
                    })
                CalculatorButton(
                    symbol = "+",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        calculator.updateString("+");
                    })
            }
            Row(
                modifier = Modifier.weight(1f).fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CalculatorButton(
                    symbol = "00",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("00");
                    })
                CalculatorButton(
                    symbol = "0",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString("0");
                    })
                CalculatorButton(
                    symbol = ".",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        calculator.updateString(".");
                    })
                CalculatorButton(
                    symbol = "=",
                    style = ButtonStyle.GREEN,
                    onClick = {
                        calculator.calculate();
                    })
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