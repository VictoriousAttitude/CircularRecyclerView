package com.example.dmitriy.customrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dima on 9/14/2017.
 */

public class ScrollListener extends RecyclerView.OnScrollListener {

    private int minCenterOffSet = Integer.MAX_VALUE;
    private int middleItemIndex = 0;

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

        int firstVisible = customLayoutManager.findFirstVisibleItemPosition();
        int lastVisible = customLayoutManager.findLastVisibleItemPosition();

        View view = customLayoutManager.findViewByPosition(firstVisible);
        if(view instanceof TextView)
            System.out.println("YES!");
        else
            System.out.println("NO!");

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
/*
        switch (newState) {
            case RecyclerView.SCROLL_STATE_IDLE:
                break;
            case RecyclerView.SCROLL_STATE_DRAGGING:
                break;
            case RecyclerView.SCROLL_STATE_SETTLING:
                break;
        }
*/
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (dx > 0) { // To the right
        }
        if (dx < 0) { // To the left
        }
    }
}
