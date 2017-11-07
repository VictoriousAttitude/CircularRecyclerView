package com.example.dmitriy.customrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedList;
import com.example.dmitriy.customrecyclerview.rv.Adapter;
import com.example.dmitriy.customrecyclerview.rv.CustomLayoutManager;
import com.example.dmitriy.customrecyclerview.rv.ScrollListener;

// TODO: 1. Stop scrolling when it gets to the first or last visible item OR add PAGINATION
// TODO: 2. Refactoring of ScrollListener (delete updateVisibleOnScreenViews)
public class MainActivity extends Activity {

    private RecyclerView rv;
    private Adapter adapter;
    private SnapHelper snapHelper;
    private CustomLayoutManager customLayoutManager;
    private ScrollListener scrollListener;

    private final static String [] TIME = {"05", "10", "15", "20", "25", "30",
                                           "35", "40", "45", "50", "55" };

    private final static CircularLinkedList circularLinkedList = new CircularLinkedList(TIME.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (String time : TIME)
            circularLinkedList.insert(time);

        setUpCustomization();
        setUpRV();
        scrollRecyclerView();
    }

    private void setUpCustomization() {
        adapter = new Adapter(circularLinkedList);
        snapHelper = new LinearSnapHelper();
        customLayoutManager = new CustomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        scrollListener = new ScrollListener(customLayoutManager);
    }

    private void setUpRV() {
        rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);
        rv.setLayoutManager(customLayoutManager);
        rv.addOnScrollListener(scrollListener);
      //rv.addItemDecoration(new SpaceItemDecoration(5));
        snapHelper.attachToRecyclerView(rv);
    }

    private void scrollRecyclerView() {
        rv.getLayoutManager().scrollToPosition((Integer.MAX_VALUE / 2) - 1);
    }
}
