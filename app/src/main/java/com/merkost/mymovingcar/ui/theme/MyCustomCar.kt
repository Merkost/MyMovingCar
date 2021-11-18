package com.merkost.mymovingcar.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.merkost.mymovingcar.toDp

@Composable
fun MyCustomCar(modifier: Modifier = Modifier) {
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