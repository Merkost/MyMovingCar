package com.merkost.mymovingcar

import android.content.res.Resources
import androidx.compose.ui.unit.dp

val Float.toPx get() = (this * Resources.getSystem().displayMetrics.density)
val Float.toDp get() = this.div(Resources.getSystem().displayMetrics.density).dp

val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()
val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt().dp