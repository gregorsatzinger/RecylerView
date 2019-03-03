package com.example.gregor.recylerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Project: Multiple Timer stacked in RecyclerView
 * TODO: Button for adding new timers, input field for time value
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> lInfo = new ArrayList<>();
    private ArrayList<Integer> lValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");

        initProgressBar();
    }
    private void initProgressBar(){
        Log.d(TAG, "initProgressBar: init progress bar");
        lInfo.add("Progressbar #"+(lInfo.size()+1));
        lValues.add(30);

        lInfo.add("Progressbar #"+(lInfo.size()+1));
        lValues.add(20);

        lInfo.add("Progressbar #"+(lInfo.size()+1));
        lValues.add(70);

        lInfo.add("Progressbar #"+(lInfo.size()+1));
        lValues.add(60);

        lInfo.add("Progressbar #"+(lInfo.size()+1));
        lValues.add(90);

        lInfo.add("Progressbar #"+(lInfo.size()+1));
        lValues.add(30);

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,lInfo,lValues);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
