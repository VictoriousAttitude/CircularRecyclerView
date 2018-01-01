package com.example.dmitriy.customrecyclerview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by Dima on 1/1/2018.
 */

public class Util {
    private Context context;

    public Util(Context context) {
        this.context = context;
    }

    public float convertDpToPixel(float dp) {
        float densityDpi = (float) context.getResources().getDisplayMetrics().densityDpi;
        return dp * (densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float convertSpToPixel(float sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    public float convertPixelsToDp(float px) {
        float densityDpi = (float) context.getResources().getDisplayMetrics().densityDpi;
        return px / (densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float getScreenWidth() {
        return (float) context.getResources().getDisplayMetrics().widthPixels;
    }

    public float getScreenHeight() {
        return (float) context.getResources().getDisplayMetrics().heightPixels;
    }

}