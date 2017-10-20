package com.example.dmitriy.customrecyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    // How to find central view in RecyclerView (metrics in pixels)
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

    // TODO: Changing logic of [dx > 0 and dx < 0] when upgrade to circular in both ways RecyclerView
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int firstVisible = customLayoutManager.findFirstVisibleItemPosition();
        int centralVisible = firstVisible + 2; // because only 5 views are visible at the same time

        View view = customLayoutManager.findViewByPosition(centralVisible);
        TextView childTimeTV = (TextView) view.findViewById(R.id.time_text);

        if (childTimeTV != null)
            setBasicTextCustomization(true, childTimeTV);

        if (dx > 0) { // To the right
            if (firstVisible != 0) {
                View view1 = customLayoutManager.findViewByPosition(centralVisible - 1);
                TextView childTimeTV1 = (TextView) view1.findViewById(R.id.time_text);
                setBasicTextCustomization(false, childTimeTV1);
            }
        }
        if (dx < 0) { // To the left
            if (firstVisible != 0) {
                View view2 = customLayoutManager.findViewByPosition(centralVisible + 1);
                TextView childTimeTV2 = (TextView) view2.findViewById(R.id.time_text);
                setBasicTextCustomization(false, childTimeTV2);
            }
        }
    }

    private void setBasicTextCustomization(boolean isTextViewCentral, TextView timeTextView) {
        if (isTextViewCentral) {
            timeTextView.setTextSize(60f);
            timeTextView.setTextColor(Color.BLUE);
            timeTextView.setPadding(5, 5, 0, 0);
        } else {
            timeTextView.setTextSize(35f);
            timeTextView.setTextColor(Color.BLACK);
            timeTextView.setPadding(0, 0, 0, 0);
        }
    }

}
