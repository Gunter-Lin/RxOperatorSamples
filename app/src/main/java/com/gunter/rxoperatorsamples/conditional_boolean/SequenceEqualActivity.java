package com.gunter.rxoperatorsamples.conditional_boolean;

import android.os.Bundle;

import com.gunter.rxoperatorsamples.BaseActivity;

import rx.Observable;

public class SequenceEqualActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLButton.setText("equal");
        mLButton.setOnClickListener(e -> equalObserver().subscribe(i -> log("equal:" + i)));
        mRButton.setText("notequal");
        mRButton.setOnClickListener(e -> notEqualObserver().subscribe(i -> log("notequal:" + i)));
    }

    private Observable<Boolean> equalObserver() {
        return Observable.sequenceEqual(Observable.just(1, 2, 3), Observable.just(1, 2, 3));
    }

    private Observable<Boolean> notEqualObserver() {
        return Observable.sequenceEqual(Observable.just(1, 2, 3), Observable.just(1, 2));
    }
}


