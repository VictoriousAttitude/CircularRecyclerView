package com.example.dmitriy.customrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Info> data = new ArrayList<>();
    private Adapter adapter;
    private SnapHelper snapHelper;

    private final static String [] TIME = {"5", "10", "15", "20", "25", "30",
                                           "35", "40", "45", "50", "55" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new Adapter(this, data);

        CustomLayoutManager customLayoutManager
                = new CustomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ScrollListener scrollListener = new ScrollListener(this, customLayoutManager);

        for (String time : TIME)
            data.add(new Info(time));

        snapHelper = new LinearSnapHelper();
      //View view = snapHelper.findSnapView(customLayoutManager);

        rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);
        rv.setLayoutManager(customLayoutManager);
        rv.addOnScrollListener(scrollListener);
      //rv.addItemDecoration(new SpaceItemDecoration(5));
        snapHelper.attachToRecyclerView(rv);
    }

}
