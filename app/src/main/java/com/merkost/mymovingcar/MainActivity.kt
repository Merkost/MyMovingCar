package com.merkost.mymovingcar

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merkost.mymovingcar.ui.theme.MyMovingCarTheme
import kotlinx.coroutines.delay

val Float.toPx get() = (this * Resources.getSystem().displayMetrics.density)
val Float.toDp get() = this.div(Resources.getSystem().displayMetrics.density).dp

val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt().dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MyMovingCarTheme {
                Surface(Modifier.fillMaxSize()) {
                    var iter by remember{ mutableStateOf(10) }
                    var carPosition by remember { mutableStateOf(CarPosition.TopLeft) }
                    val transition =
                        updateTransition(targetState = carPosition, label = "carPosition")

                    val carOffset by transition.animateOffset(label = "Car") { position ->
                        when (position) {
                            CarPosition.TopLeft -> Offset.Zero
                            CarPosition.BottomRight -> Offset(260f, 260f)
                            CarPosition.TopRight -> Offset(260f, 0F)
                            CarPosition.BottomLeft -> Offset(0F, 260f)
                        }
                    }

                    LaunchedEffect(carPosition) {
                        if (iter < 3) {

                            delay(400)
                            carPosition = getNextPosition(carPosition)
                            iter++
                        }

                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text("Update Transition", fontSize = 32.sp)
                        Button(
                            modifier = Modifier.padding(top = 20.dp, bottom = 30.dp),
                            onClick = {
                                iter=0
                                carPosition = getNextPosition(carPosition)
                            }
                        ) {
                            Text("Move now!")
                        }
                        Box(modifier = Modifier
                            .size(300.dp)
                            .background(Color.White).border(BorderStroke(2.dp, Color.Gray))
                        ) {
                            Car(modifier = Modifier
                                .offset(carOffset.x.dp, carOffset.y.dp)
                                .background(Color.Yellow))
                        }
                    }
                }
                // A surface container using the 'background' color from the theme
                //Surface(color = MaterialTheme.colors.background) {
                //Greeting("Android")
                //Car()
                //}
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
        Car()
    }
}

@Composable
fun Car(modifier: Modifier = Modifier) {
    val density = LocalDensity.current
    Canvas(modifier = modifier.size(110f.toDp).background(Color.White)) {
        //with(density) {

        //RedBottom
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(15f, 50f),
            size = Size(80f, 40f),
            cornerRadius = CornerRadius(7f)
        )
        //RedTop
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(22f, 20f),
            size = Size(65f, 35f),
            cornerRadius = CornerRadius(6f)
        )
        //WheelLeft
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(22f, 82f),
            size = Size(14f, 20f),
            cornerRadius = CornerRadius(6f)
        )
        //WheelRight
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(74f, 82f),
            size = Size(14f, 20f),
            cornerRadius = CornerRadius(6f)
        )
        //Window
        drawRoundRect(
            color = Color.Blue,
            topLeft = Offset(25f, 22f),
            size = Size(60f, 26f),
            cornerRadius = CornerRadius(6f)
        )
        //WindowBottom
        drawRoundRect(
            color = Color.Blue,
            topLeft = Offset(25f, 40f),
            size = Size(60f, 9f),
            cornerRadius = CornerRadius(0f)
        )
        //LeftEar
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(9f, 42f),
            size = Size(13f, 8f),
            cornerRadius = CornerRadius(3f)
        )
        //RightEar
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(88f, 42f),
            size = Size(13f, 8f),
            cornerRadius = CornerRadius(3f)
        )

        //Bumper
        drawRoundRect(
            color = Color.LightGray,
            topLeft = Offset(13f, 80f),
            size = Size(84f, 11f),
            cornerRadius = CornerRadius(3f)
        )
        //Radiator
        drawRoundRect(
            color = Color.LightGray,
            topLeft = Offset(36f, 51f),
            size = Size(38f, 38f),
            cornerRadius = CornerRadius(8f)
        )
        //NumberPlate
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(44f, 81f),
            size = Size(22f, 8f),
            cornerRadius = CornerRadius(2f)
        )
        //LeftLampBottom
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(18f, 70f),
            size = Size(15f, 8f),
            cornerRadius = CornerRadius(8f)
        )


        //RightLampBottom
        drawRoundRect(
            color = Color.White,
            topLeft = Offset(77f, 70f),
            size = Size(15f, 8f),
            cornerRadius = CornerRadius(8f)
        )

        //RadLines
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(41f, 78f),
            size = Size(28f, 1f),
            cornerRadius = CornerRadius(2f)
        )
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(41f, 74f),
            size = Size(28f, 1f),
            cornerRadius = CornerRadius(2f)
        )
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(41f, 70f),
            size = Size(28f, 1f),
            cornerRadius = CornerRadius(2f)
        )
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(41f, 66f),
            size = Size(28f, 1f),
            cornerRadius = CornerRadius(2f)
        )
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(41f, 62f),
            size = Size(28f, 1f),
            cornerRadius = CornerRadius(20f)
        )
        drawRoundRect(
            color = Color.DarkGray,
            topLeft = Offset(41f, 58f),
            size = Size(28f, 1f),
            cornerRadius = CornerRadius(2f)
        )


    }
}

enum class CarPosition {
    TopLeft,
    BottomRight,
    TopRight,
    BottomLeft
}
