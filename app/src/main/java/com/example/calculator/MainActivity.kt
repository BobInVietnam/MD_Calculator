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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
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
import java.util.Stack

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
    var CalcString = "0"

    fun updateString(string: String) {
        if (CalcString == "0") CalcString = string
        else CalcString += string
    }
    fun clearAll() {
        CalcString = "0"
        calcResult = 0
    }
    fun clearOne() {
        CalcString.dropLast(1)
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
    var calcResult by remember { mutableDoubleStateOf(0.0) }
    var calcString by remember { mutableStateOf("0") }
    var isDecimal = false

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Box(Modifier.height(32.dp).background(Color(255, 232, 120)))
        Column (
            modifier = Modifier.weight(1f).fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(text = calcString,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color(103, 103, 103, 255)
            )
            Spacer(Modifier.height(20.dp))
            Text(calcResult.toString(),
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
                        calcString = "0"
                        calcResult = 0.0
                    })
                CalculatorButton(
                    symbol = "del",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString.length == 1) {
                            calcString = "0";
                        } else {
                            calcString = calcString.dropLast(1);
                        }
                    })
                CalculatorButton(
                    symbol = "%",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString.last().isDigit())
                            calcString += "%"
                    })
                CalculatorButton(
                    symbol = "/",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        if (calcString.last().isDigit()) {
                            calcString += "/"
                            isDecimal = false;
                        }
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
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "7"
                    })
                CalculatorButton(
                    symbol = "8",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "8"
                    })
                CalculatorButton(
                    symbol = "9",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "9"
                    })
                CalculatorButton(
                    symbol = "X",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        if (calcString.last().isDigit()) {
                            calcString += "*"
                            isDecimal = false;
                        }
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
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "4"
                    })
                CalculatorButton(
                    symbol = "5",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "5"
                    })
                CalculatorButton(
                    symbol = "6",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "6"
                    })
                CalculatorButton(
                    symbol = "-",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        if (calcString == "0") calcString = "-"
                        if (calcString.last().isDigit()) {
                            calcString += "-"
                            isDecimal = false;
                        }
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
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "1"
                    })
                CalculatorButton(
                    symbol = "2",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "2"
                    })
                CalculatorButton(
                    symbol = "3",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString == "0") calcString = calcString.dropLast(1)
                        calcString += "3"
                    })
                CalculatorButton(
                    symbol = "+",
                    style = ButtonStyle.YELLOW,
                    onClick = {
                        if (calcString.last().isDigit()) {
                            calcString += "+"
                            isDecimal = false;
                        }
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
                        if (calcString != "0") calcString += "00"
                    })
                CalculatorButton(
                    symbol = "0",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString != "0") calcString += "0"
                    })
                CalculatorButton(
                    symbol = ".",
                    style = ButtonStyle.NEUTRAL,
                    onClick = {
                        if (calcString.last().isDigit() && !isDecimal) {
                            calcString += "."
                            isDecimal = true
                        }
                    })
                CalculatorButton(
                    symbol = "=",
                    style = ButtonStyle.GREEN,
                    onClick = {
                        calcResult = calculate(calcString);
                    })
            }
        }
    }
}

fun calculate(expression: String): Double {
    // 1. Pre-process to handle percentage as a value (e.g., 20% -> 0.2)
    // We replace "number%" with "(number/100)"
    val cleanedExpr = expression.replace(Regex("(\\d+\\.?\\d*)%")) {
        "(${it.groupValues[1]}/100)"
    }

    // 2. Tokenize the string (Numbers, Operators, Parentheses)
    val tokens = Regex("(\\d+\\.?\\d*)|([+\\-*/()])")
        .findAll(cleanedExpr)
        .map { it.value }
        .toList()

    val precedence = mapOf("+" to 1, "-" to 1, "*" to 2, "/" to 2)
    val output = mutableListOf<String>()
    val stack = Stack<String>()

    // 3. Shunting-yard: Infix to Postfix (RPN)
    for (token in tokens) {
        when {
            token.toDoubleOrNull() != null -> output.add(token)
            token == "(" -> stack.push(token)
            token == ")" -> {
                while (stack.isNotEmpty() && stack.peek() != "(") output.add(stack.pop())
                stack.pop() // Remove "("
            }
            else -> {
                while (stack.isNotEmpty() && stack.peek() != "(" &&
                    precedence[stack.peek()]!! >= precedence[token]!!) {
                    output.add(stack.pop())
                }
                stack.push(token)
            }
        }
    }
    while (stack.isNotEmpty()) output.add(stack.pop())

    // 4. Evaluate the Postfix expression
    val evaluationStack = Stack<Double>()
    for (token in output) {
        val value = token.toDoubleOrNull()
        if (value != null) {
            evaluationStack.push(value)
        } else {
            val b = evaluationStack.pop()
            val a = evaluationStack.pop()
            when (token) {
                "+" -> evaluationStack.push(a + b)
                "-" -> evaluationStack.push(a - b)
                "*" -> evaluationStack.push(a * b)
                "/" -> evaluationStack.push(a / b)
            }
        }
    }
    return evaluationStack.pop()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Calculator()
    }
}