package com.example.dmitriy.customrecyclerview.rv;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Dima on 9/22/2017.
 */

public final class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int distance;

    public SpaceItemDecoration(int distance) {
        this.distance = distance;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = distance;
        outRect.right = distance;
    }
}
