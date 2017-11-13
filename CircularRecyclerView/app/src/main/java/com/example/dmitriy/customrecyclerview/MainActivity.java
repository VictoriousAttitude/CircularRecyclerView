package com.example.dmitriy.customrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedList;
import com.example.dmitriy.customrecyclerview.rv.Adapter;
import com.example.dmitriy.customrecyclerview.rv.CustomLayoutManager;
import com.example.dmitriy.customrecyclerview.rv.CustomScrollListener;
import com.example.dmitriy.customrecyclerview.rv.CustomSnapHelper;
import com.example.dmitriy.customrecyclerview.rv.MyRecyclerView;


public class MainActivity extends Activity {

    private MyRecyclerView rv;
    private Adapter adapter;
    private CustomSnapHelper customCustomSnapHelper;
    private CustomLayoutManager customLayoutManager;
    private CustomScrollListener customScrollListener;

    private final static String [] TIME = {"05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "00" };
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
        customCustomSnapHelper = new CustomSnapHelper();
        customLayoutManager = new CustomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        customScrollListener = new CustomScrollListener(customLayoutManager);
    }

    private void setUpRV() {
        rv = findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);
        rv.setLayoutManager(customLayoutManager);
        rv.addOnScrollListener(customScrollListener);
      //rv.addItemDecoration(new SpaceItemDecoration(5));
        customCustomSnapHelper.attachToRecyclerView(rv);
    }

    private void scrollRecyclerView() {
        rv.getLayoutManager().scrollToPosition((Integer.MAX_VALUE / 2) - 6);
    }
}
