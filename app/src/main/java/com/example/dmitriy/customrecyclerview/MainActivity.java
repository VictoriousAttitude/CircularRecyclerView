package com.example.dmitriy.customrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedList;
import com.example.dmitriy.customrecyclerview.linkedlist.CircularLinkedListImpl;
import com.example.dmitriy.customrecyclerview.rv.Adapter;
import com.example.dmitriy.customrecyclerview.rv.CustomLayoutManager;
import com.example.dmitriy.customrecyclerview.rv.CustomScrollListener;
import com.example.dmitriy.customrecyclerview.rv.CustomSnapHelper;
import com.example.dmitriy.customrecyclerview.rv.MyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends Activity {

    @BindView(R.id.recycler_view) MyRecyclerView recyclerView;

    private CustomSnapHelper customSnapHelper;
    private CustomLayoutManager customLayoutManager;
    private CustomScrollListener customScrollListener;
    private CircularLinkedList<String> circularLinkedList;

    private final static String [] TIME = {
            "05", "10", "15", "20",
            "25", "30", "35", "40",
            "45", "50", "55", "00"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpCustomParams();
        setUpRecyclerViewParams();
    }

    private void setUpCustomParams() {
        circularLinkedList = new CircularLinkedListImpl(TIME.length);
        circularLinkedList.insertArrays(TIME);
        circularLinkedList.show();
        customSnapHelper = new CustomSnapHelper();
        customLayoutManager = new CustomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        customScrollListener = new CustomScrollListener(customLayoutManager, circularLinkedList);
    }

    private void setUpRecyclerViewParams() {
        recyclerView.setAdapter(new Adapter(circularLinkedList));
        recyclerView.setLayoutManager(customLayoutManager);
        recyclerView.addOnScrollListener(customScrollListener);
      //rv.addItemDecoration(new SpaceItemDecoration(5));
        customSnapHelper.attachToRecyclerView(recyclerView);
    }
}
