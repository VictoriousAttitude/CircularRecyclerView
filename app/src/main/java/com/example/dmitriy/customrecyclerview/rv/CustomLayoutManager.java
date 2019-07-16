package com.example.dmitriy.customrecyclerview.rv;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by Dima on 9/12/2017.
 */

public class CustomLayoutManager extends LinearLayoutManager {

    public CustomLayoutManager(Context context) {
        super(context);
     }

    public CustomLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int findFirstVisibleItemPosition() {
        return super.findFirstVisibleItemPosition();
    }

    @Override
    public int findFirstCompletelyVisibleItemPosition() {

        return super.findFirstCompletelyVisibleItemPosition();
    }
}
