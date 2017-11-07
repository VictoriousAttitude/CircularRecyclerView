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
    private int centralVisiblePosition;

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
        centralVisiblePosition = firstVisible + 2; // because only 5 views are visible at the same time
        updateVisibleOnScreenViews(centralVisiblePosition);
    }

    private void updateVisibleOnScreenViews(int centralPos) { // for preventing bugs when scrolling very fast
        View view;
        int firstPos = customLayoutManager.findFirstCompletelyVisibleItemPosition();
        int lastPos = customLayoutManager.findLastCompletelyVisibleItemPosition();

        for (int i = firstPos; i <= lastPos; ++i) {
            if (i != centralPos) {
                view = customLayoutManager.findViewByPosition(i);
                TextView tv = (TextView) view.findViewById(R.id.time_text);
                customizeTextView(false, tv);
            }
        }
    }

    private void findTextViewForCustomization(boolean isCentral, int direction) {
        final View view;

        if (isCentral)
            view = customLayoutManager.findViewByPosition(centralVisiblePosition);
        else {
            if (direction < 0)
                view = customLayoutManager.findViewByPosition(centralVisiblePosition + 1);
            else
                view = customLayoutManager.findViewByPosition(centralVisiblePosition - 1);
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
