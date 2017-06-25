package com.example.dmitriy.customrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Info> data = new ArrayList<>();
    private TimeAdapter timeAdapter;

    private final static String [] TIME = {"5", "10", "15", "20", "25", "30",
                                           "35", "40", "45", "50", "55" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (String time : TIME) {
            data.add(new Info(time));
        }

        timeAdapter = new TimeAdapter(this, data);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rv = (RecyclerView) findViewById(R.id.recycle_view);
        rv.setAdapter(timeAdapter);
        rv.setLayoutManager(/*new LinearLayoutManager(this)*/ layoutManager);
    }
}
