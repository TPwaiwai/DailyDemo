package com.tangpeng.dailydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tangpeng.dailydemo.activity.rxjava.RxjavaActivity;
import com.tangpeng.dailydemo.weight.WaitProgressDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button rxjava;
    private WaitProgressDialog waitProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rxjava = ((Button) findViewById(R.id.rxjava));
        rxjava.setOnClickListener(this);
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

    /**
     * 显示进度框
     */
    protected void showProgress() {
        waitProgressDialog = new WaitProgressDialog(this);
        waitProgressDialog.show();
    }

}
