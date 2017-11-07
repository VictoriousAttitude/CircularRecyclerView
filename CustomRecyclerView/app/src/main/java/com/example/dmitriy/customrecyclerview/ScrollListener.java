package com.example.dmitriy.customrecyclerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dima on 9/14/2017.
 */

public class ScrollListener extends RecyclerView.OnScrollListener {

    private CustomLayoutManager customLayoutManager;
    private int centralVisible;

    public ScrollListener(CustomLayoutManager customLayoutManager) {
        super();
        this.customLayoutManager = customLayoutManager;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
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
    // TODO: fix bug with very fast scrolling
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        findCentralTextView();
        findTextViewForCustomization(true, 0);

        if (dx > 0)
            findTextViewForCustomization(false, 1);
        if (dx < 0)
            findTextViewForCustomization(false, -1);
    }

    private void findCentralTextView() {
        int firstVisible = customLayoutManager.findFirstVisibleItemPosition();
        centralVisible = firstVisible + 2; // because only 5 views are visible at the same time
    }

    private void findTextViewForCustomization(boolean isCentral, int direction) {
        View view;

        if (isCentral)
            view = customLayoutManager.findViewByPosition(centralVisible);
        else {
            if (direction < 0)
                view = customLayoutManager.findViewByPosition(centralVisible + 1);
            else
                view = customLayoutManager.findViewByPosition(centralVisible - 1);
        }
        TextView tv = (TextView) view.findViewById(R.id.time_text);
        customizeTextView(isCentral, tv);
    }

    private void customizeTextView(boolean isCentral, TextView timeTextView) {
            if (isCentral) {
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
