package com.example.dmitriy.customrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedListImpl;
import com.example.dmitriy.customrecyclerview.rv.Adapter;
import com.example.dmitriy.customrecyclerview.rv.CustomLayoutManager;
import com.example.dmitriy.customrecyclerview.rv.CustomScrollListener;
import com.example.dmitriy.customrecyclerview.rv.CustomSnapHelper;
import com.example.dmitriy.customrecyclerview.rv.MyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MainActivity extends Activity {

    @BindView(R.id.recycler_view) MyRecyclerView rv;
    private Unbinder unbinder;

    private Adapter adapter;
    private CustomSnapHelper customSnapHelper;
    private CustomLayoutManager customLayoutManager;
    private CustomScrollListener customScrollListener;

    private final static String [] TIME = {"05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "00"};
    private final static CircularLinkedListImpl circularLinkedList = new CircularLinkedListImpl(TIME.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        circularLinkedList.insertArrays(TIME);
        circularLinkedList.show();

        setUpCustomization();
        setUpRV();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void setUpCustomization() {
        customSnapHelper = new CustomSnapHelper();
        customLayoutManager = new CustomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        customScrollListener = new CustomScrollListener(customLayoutManager, circularLinkedList);
    }

    private void setUpRV() {
        adapter = new Adapter(circularLinkedList);
        rv.setAdapter(adapter);
        rv.setLayoutManager(customLayoutManager);
        rv.addOnScrollListener(customScrollListener);
      //rv.addItemDecoration(new SpaceItemDecoration(5));
        customSnapHelper.attachToRecyclerView(rv);
    }
}
