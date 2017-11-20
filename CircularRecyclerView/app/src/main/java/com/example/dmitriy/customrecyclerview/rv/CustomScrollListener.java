package com.example.dmitriy.customrecyclerview.rv;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.dmitriy.customrecyclerview.R;
import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedListImpl;

/**
 * Created by Dima on 9/14/2017.
 */

public class CustomScrollListener extends RecyclerView.OnScrollListener {

    private CustomLayoutManager customLayoutManager;
    private CircularLinkedListImpl circularLinkedListImpl;
    private int centralVisiblePos, firstVisiblePos, lastVisiblePos;
    private final static int SCROLLING_STEP = 3;

    public CustomScrollListener(CustomLayoutManager customLayoutManager, CircularLinkedListImpl circularLinkedListImpl) {
        super();
        this.customLayoutManager = customLayoutManager;
        this.circularLinkedListImpl = circularLinkedListImpl;
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
        findCenterTextView(dx);
    }

    private void updateVisibleOnScreenViews(int centralPos) {
        firstVisiblePos = customLayoutManager.findFirstVisibleItemPosition();
        lastVisiblePos = customLayoutManager.findLastVisibleItemPosition();

        if (firstVisiblePos == circularLinkedListImpl.getFirstArrFirstPos())
            customLayoutManager.scrollToPosition(circularLinkedListImpl.getThirdArrFirstPos() + SCROLLING_STEP);
        else {
            if (lastVisiblePos == circularLinkedListImpl.getThirdArrLastPos())
                customLayoutManager.scrollToPosition(circularLinkedListImpl.getFirstArrLastPos() - SCROLLING_STEP);
        }

        for (int i = firstVisiblePos; i <= lastVisiblePos; ++i) {
            TextView tv = (TextView) customLayoutManager.findViewByPosition(i).findViewById(R.id.time_text);

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

    private void findCenterTextView(int direction) { // currently don't check horizontal direction
        centralVisiblePos = customLayoutManager.findFirstCompletelyVisibleItemPosition() + 2;
        updateVisibleOnScreenViews(centralVisiblePos);
    }
}
