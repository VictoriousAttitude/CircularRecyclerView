package com.example.dmitriy.customrecyclerview.rv;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.dmitriy.customrecyclerview.R;
import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedList;

/**
 * Created by Dima on 9/14/2017.
 */

public class CustomScrollListener extends RecyclerView.OnScrollListener {
    private final CustomLayoutManager customLayoutManager;
    private final CircularLinkedList circularLinkedList;
    private int centralVisiblePos = 0;
    private int firstVisiblePos = 0;
    private int lastVisiblePos = 0;
    private final static int SCROLLING_STEP = 3;


    public CustomScrollListener(CustomLayoutManager customLayoutManager, CircularLinkedList circularLinkedList) {
        super();
        this.customLayoutManager = customLayoutManager;
        this.circularLinkedList = circularLinkedList;
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
        setUpPosOfElems();
        scrollItems();
        highlightElems();
    }

    private void highlightElems() {
        for (int i = firstVisiblePos; i <= lastVisiblePos; ++i) {
            TextView textView = customLayoutManager.findViewByPosition(i).findViewById(R.id.time_text);

            if (i != centralVisiblePos)
                customizeItemsStyle(textView, false);
            else
                customizeItemsStyle(textView, true);
        }
    }

    private void scrollItems() {
        if (firstVisiblePos == circularLinkedList.getFirstArrFirstPos())
            customLayoutManager.scrollToPosition(circularLinkedList.getThirdArrFirstPos() + SCROLLING_STEP);
        else {
            if (lastVisiblePos == circularLinkedList.getThirdArrLastPos())
                customLayoutManager.scrollToPosition(circularLinkedList.getFirstArrLastPos() - SCROLLING_STEP);
        }
    }

    private void customizeItemsStyle(TextView textView, boolean isCenter) {
        if (isCenter) {
            textView.setTextSize(60f);
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.colorBlue));
            textView.setPadding(5, 5, 0, 0);
        } else {
            textView.setTextSize(35f);
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.colorBlack));
            textView.setPadding(0, 0, 0, 0);
        }
    }

    private void setUpPosOfElems() {
        firstVisiblePos = customLayoutManager.findFirstVisibleItemPosition();
        lastVisiblePos = customLayoutManager.findLastVisibleItemPosition();
        centralVisiblePos = customLayoutManager.findFirstCompletelyVisibleItemPosition() + 2;
    }
}
