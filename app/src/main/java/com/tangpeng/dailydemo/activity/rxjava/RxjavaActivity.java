package com.tangpeng.dailydemo.activity.rxjava;

import android.database.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tangpeng.dailydemo.R;

/**
 * Created by tangpeng on 2017/5/16.
 */

public class RxjavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        testObservable();

    }

    /**
     *被观察者Observable
     * 观察者Observer
     *
     *
     */
    private void testObservable() {


    }
}
