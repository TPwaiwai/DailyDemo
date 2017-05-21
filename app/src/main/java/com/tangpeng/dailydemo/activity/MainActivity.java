package com.tangpeng.dailydemo.activity;

import android.content.Intent;
import android.view.View;

import com.tangpeng.dailydemo.R;
import com.tangpeng.dailydemo.activity.rxjava.RxjavaActivity;
import com.tangpeng.dailydemo.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        showProgress();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rxjava:
                startActivity(new Intent(this, RxjavaActivity.class));
                break;
        }
    }

}

