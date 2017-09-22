package com.example.dmitriy.customrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Dima on 9/14/2017.
 */

public class ScrollListener extends RecyclerView.OnScrollListener {

    private CustomLayoutManager customLayoutManager;
    private Context context;


    public ScrollListener(Context context, CustomLayoutManager customLayoutManager) {
        super();
        this.context = context;
        this.customLayoutManager = customLayoutManager;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
/*
        int firstVisible = customLayoutManager.findFirstVisibleItemPosition();
        int lastVisible = customLayoutManager.findLastVisibleItemPosition();
        int itemsCount = lastVisible - firstVisible + 1;
        int screenCenter = context.getResources().getDisplayMetrics().widthPixels / 2;

        for (int index = 0; index < itemsCount; ++index) {

            View item = customLayoutManager.getChildAt(index);
            if (item == null)
                break;

            int left = item.getLeft();
            int right = item.getRight();
            center = Math.abs(left - right) + Math.abs(right - screenCenter); // center element in RecyclerView in pixels

            if (minCenterOffSet > center) {
                minCenterOffSet = center;
                middleItemIndex = index + firstVisible;
            }
        }
*/
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int firstVisible = customLayoutManager.findFirstVisibleItemPosition();
        int lastVisible = customLayoutManager.findLastVisibleItemPosition();
        int centralVisible = firstVisible + 2; // because only 5 views are visible at the same time

        View view = customLayoutManager.findViewByPosition(centralVisible);

        if (view instanceof LinearLayout) {

            TextView childTimeTV = (TextView) view.findViewById(R.id.time_text);

            if (childTimeTV != null) {
                childTimeTV.setTextSize(60f);
                childTimeTV.setTextColor(Color.BLUE);
                childTimeTV.setPadding(5, 5, 0, 0);
            }
        }

        if (dx > 0) { // To the right
        }
        if (dx < 0) { // To the left
        }
    }

}
