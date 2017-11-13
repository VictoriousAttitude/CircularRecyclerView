package com.example.dmitriy.customrecyclerview.rv;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.dmitriy.customrecyclerview.R;

/**
 * Created by Dima on 9/14/2017.
 */

public class CustomScrollListener extends RecyclerView.OnScrollListener {

    private CustomLayoutManager customLayoutManager;
    private int centralVisiblePosition;

    public CustomScrollListener(CustomLayoutManager customLayoutManager) {
        super();
        this.customLayoutManager = customLayoutManager;
    }
/*
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

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
            int center = Math.abs(left - right) + Math.abs(right - screenCenter); // center element in RecyclerView in pixels

            if (minCenterOffSet > center) {
                minCenterOffSet = center;
                middleItemIndex = index + firstVisible;
            }
        }
    }
*/
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        findCenterTextView(recyclerView, dx);
    }

    private void updateVisibleOnScreenViews(RecyclerView rv, int centralPos) {
        int firstPos = customLayoutManager.findFirstVisibleItemPosition();
        int lastPos = customLayoutManager.findLastVisibleItemPosition();

        for (int i = firstPos; i <= lastPos; ++i) {
            TextView tv = (TextView) customLayoutManager.findViewByPosition(i).findViewById(R.id.time_text);

          //if (rv.findContainingViewHolder(tv).getLayoutPosition() == customLayoutManager.findFirstCompletelyVisibleItemPosition())
            if (i != centralPos)
                customizeText(tv, false);
            else
                customizeText(tv, true);
        }
    }

    private void customizeText(TextView tv, boolean isCenter) {
        if (isCenter) {
            tv.setTextSize(60f);
            tv.setTextColor(tv.getContext().getResources().getColor(R.color.colorBlue));
            tv.setPadding(5, 5, 0, 0);
        } else {
            tv.setTextSize(35f);
            tv.setTextColor(tv.getContext().getResources().getColor(R.color.colorBlack));
            tv.setPadding(0, 0, 0, 0);
        }
    }

    private void findCenterTextView(RecyclerView rv, int direction) {
        if (direction >= 0)
            centralVisiblePosition = customLayoutManager.findFirstCompletelyVisibleItemPosition() + 2;
        if (direction < 0)
            centralVisiblePosition = customLayoutManager.findLastCompletelyVisibleItemPosition() - 2;

        updateVisibleOnScreenViews(rv, centralVisiblePosition);
    }
}
