package com.gunter.rxoperatorsamples.creatingobserver;

import android.os.Bundle;

import com.gunter.rxoperatorsamples.BaseActivity;

import rx.Observable;

public class DeferAndJustActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable<Long> deferObservable = DeferObserver();
        Observable<Long> justObservable = JustObserver();
        mLButton.setText("Defer");
        mRButton.setText("Just");
        mLButton.setOnClickListener(e -> deferObservable.subscribe(time -> log("defer:" + time)));
        mRButton.setOnClickListener(e -> justObservable.subscribe(time -> log("just:" + time)));
    }

    private Observable<Long> DeferObserver() {
        return Observable.defer(() -> Observable.just(System.currentTimeMillis()));
    }

    private Observable<Long> JustObserver() {
        return Observable.just(System.currentTimeMillis());
    }


}
