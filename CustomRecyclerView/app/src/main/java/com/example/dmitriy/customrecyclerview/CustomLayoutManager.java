package com.example.dmitriy.customrecyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
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

    @Override
    public int findLastVisibleItemPosition() {
        return super.findLastVisibleItemPosition();
    }

    @Override
    public int findLastCompletelyVisibleItemPosition() {
        return super.findLastCompletelyVisibleItemPosition();
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
    }

}
