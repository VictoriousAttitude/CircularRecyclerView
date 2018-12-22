package com.example.dmitriy.customrecyclerview.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Dima on 11/13/2017.
 */

public class CustomSnapHelper extends LinearSnapHelper {

    private OrientationHelper verticalHelper, horizontalHelper;

    public CustomSnapHelper() {
    }

    @Override
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View targetView) {
        int [] out = new int[2];

        if (layoutManager.canScrollHorizontally())
            out[0] = distanceToStart(targetView, getHorizontalHelper(layoutManager));
        else
            out[0] = 0;

        return out;
    }

    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            if (layoutManager.canScrollHorizontally())
                return getStartView(layoutManager, getHorizontalHelper(layoutManager));
            else
                return getStartView(layoutManager, getVerticalHelper(layoutManager));
        }
        return super.findSnapView(layoutManager);
    }

    private int distanceToStart(View targetView, OrientationHelper helper) {
        return helper.getDecoratedStart(targetView);
    }

    private View getStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper helper) {
        if (layoutManager instanceof LinearLayoutManager) {

            int firstChild = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
            boolean isLastItem = ((LinearLayoutManager) layoutManager).
                    findLastVisibleItemPosition() == layoutManager.getItemCount() - 1;

            if (firstChild == RecyclerView.NO_POSITION || isLastItem)
                return null;

            View child = layoutManager.findViewByPosition(firstChild);
            if (helper.getDecoratedEnd(child) > helper.getDecoratedMeasurement(child) / 2 && helper.getDecoratedEnd(child) > 0)
                return child;
            else {
                if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() == layoutManager.getItemCount() - 1)
                    return null;
                else
                    return layoutManager.findViewByPosition(firstChild + 1);
            }
        }
        return super.findSnapView(layoutManager);
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (verticalHelper == null)
            verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);

        return verticalHelper;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (horizontalHelper == null)
            horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);

        return horizontalHelper;
    }
}
