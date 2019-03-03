package com.example.gregor.recylerview;

import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class WorkoutCountdownTimer extends CountDownTimer {

    ProgressBar pb;
    int progress;
    int steps;
    public WorkoutCountdownTimer(long millisInFuture, long countDownInterval, ProgressBar pb) {
        super(millisInFuture, countDownInterval);
        this.pb = pb;
        steps = (int) (pb.getMax()*countDownInterval/millisInFuture);
    }

    @Override
    public void onTick(long l) {
        progress+=steps;
        pb.setProgress(progress);
    }

    @Override
    public void onFinish() {
        pb.setProgress(0);
    }
}
