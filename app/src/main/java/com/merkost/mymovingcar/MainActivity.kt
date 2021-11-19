package com.merkost.mymovingcar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merkost.mymovingcar.ui.theme.MyCustomCar
import com.merkost.mymovingcar.ui.theme.MyMovingCarTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyMovingCarTheme {
                Surface(Modifier.fillMaxSize()) {
                    val animationDuration: Int = 1000
                    var iter by remember { mutableStateOf(10) }
                    var carPosition by remember { mutableStateOf(CarPosition.TopLeft) }
                    val transition =
                        updateTransition(targetState = carPosition, label = "carPosition")

                    val carOffset: Offset by animateOffsetAsState(
                        when (carPosition) {
                            CarPosition.TopLeft -> Offset.Zero
                            CarPosition.BottomRight -> Offset(260f, 260f)
                            CarPosition.TopRight -> Offset(260f, 0F)
                            CarPosition.BottomLeft -> Offset(0F, 260f)
                        },
                        /*when (carPosition) {
                            CarPosition.TopLeft -> spring(dampingRatio = Spring.DampingRatioLowBouncy)
                            CarPosition.BottomRight -> spring(stiffness = Spring.StiffnessLow)
                            CarPosition.TopRight -> tween(1000)
                            CarPosition.BottomLeft ->  tween(animationDuration, easing = FastOutSlowInEasing)
                        },*/
                        //spring(dampingRatio = Spring.DampingRatioLowBouncy)
                        //spring(stiffness = Spring.StiffnessLow)
                        //tween(1000)
                        tween(animationDuration, easing = FastOutSlowInEasing) //Like a real car
                    )

                    LaunchedEffect(carPosition) {
                        if (iter < 3) {
                            delay(animationDuration.toLong())
                            carPosition = getNextPosition(carPosition)
                            iter++
                        }

                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Update Transition", fontSize = 32.sp)
                        Button(
                            modifier = Modifier.padding(top = 20.dp, bottom = 30.dp),
                            onClick = {
                                iter = 0
                                carPosition = getNextPosition(carPosition)
                            }
                        ) {
                            Text("Move now!")
                        }
                        Box(
                            modifier = Modifier
                                .size(300.dp)
                                .background(Color.White).border(BorderStroke(2.dp, Color.Gray))
                        ) {
                            MyCustomCar(
                                modifier = Modifier
                                    .offset(carOffset.x.dp, carOffset.y.dp)
                                    .background(Color.Yellow)
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun getNextPosition(position: CarPosition) =
    when (position) {
        CarPosition.TopLeft -> CarPosition.BottomRight
        CarPosition.BottomRight -> CarPosition.TopRight
        CarPosition.TopRight -> CarPosition.BottomLeft
        CarPosition.BottomLeft -> CarPosition.TopLeft
    }

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyMovingCarTheme {
        //Greeting("Android")
        MyCustomCar()
    }
}


