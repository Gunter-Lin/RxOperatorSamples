package com.gunter.rxoperatorsamples.transforming;

import android.os.Bundle;

import com.gunter.rxoperatorsamples.BaseActivity;

import java.util.ArrayList;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class ScanActivity extends BaseActivity {
    ArrayList<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 10; i++) {
            list.add(2);
        }
        mLButton.setText("scan");
        mLButton.setOnClickListener(e -> scanObserver().subscribe(i -> log("scan:" + i)));
    }

    private Observable<Integer> scanObserver() {
        return Observable.from(list).scan((x, y) -> x * y).observeOn(AndroidSchedulers.mainThread());
    }

}

