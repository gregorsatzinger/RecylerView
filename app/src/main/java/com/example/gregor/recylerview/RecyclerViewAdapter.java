package com.example.gregor.recylerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> lInformation = new ArrayList<>();
    private ArrayList<Integer> lProgressValues = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> lInformation, ArrayList<Integer> lProgressValues) {
        this.lInformation = lInformation;
        this.lProgressValues = lProgressValues;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");
        viewHolder.infoText.setText(lInformation.get(i));
        viewHolder.progressBar.setProgress(lProgressValues.get(i));
        
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked on List");
                Toast.makeText(context,lInformation.get(i),Toast.LENGTH_SHORT).show();
                WorkoutCountdownTimer countdownTimer = new WorkoutCountdownTimer(10000,60,viewHolder.progressBar);
                countdownTimer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lInformation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView infoText;
        ProgressBar progressBar;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            infoText = itemView.findViewById(R.id.item_info);
            progressBar = itemView.findViewById(R.id.progressBar);
            parentLayout = itemView.findViewById(R.id.linear_layout);
        }
    }
}
