package com.example.dmitriy.customrecyclerview.util

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

fun convertDpToPixels(dp: Float, context: Context): Float {
    val densityDp = context.resources.displayMetrics.densityDpi.toFloat()
    return dp * (densityDp  / DisplayMetrics.DENSITY_DEFAULT)
}

fun convertSpToPixels(sp: Float, context: Context): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics)
}

fun convertPixelsToDp(px: Float, context: Context): Float {
    val densityDpi = context.resources.displayMetrics.densityDpi.toFloat()
    return px / (densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}

fun getScreenWidth(context: Context): Float {
    return context.resources.displayMetrics.widthPixels.toFloat()
}

fun getScreenHeight(context: Context): Float {
    return context.resources.displayMetrics.heightPixels.toFloat()
}