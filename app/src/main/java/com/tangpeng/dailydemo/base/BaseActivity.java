package com.tangpeng.dailydemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.tangpeng.dailydemo.utils.AutoUtils;
import com.tangpeng.dailydemo.weight.LoadingDialog;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by tangpeng on 2017/5/21.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected CompositeSubscription mCompositeSubscription;
    private ViewGroup rootView;
    private boolean isAuto = true;

    protected String TAG;
    private LoadingDialog waitProgressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //配置Rxjava
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        TAG = this.getClass().getSimpleName();
        //加载布局
        rootView = ((ViewGroup) getLayoutInflater().inflate(getContentViewId(), null));
        setContentView(rootView);
        //黄牛刀配置
        initView();

        //屏幕适配
        if (isAuto) {
            AutoUtils.setSize(this, true, 720, 1200);
            AutoUtils.auto(this);
        }


    }


    public void setAuto(boolean isAuto) {
        this.isAuto = isAuto;
    }


    public abstract void initView();

    protected abstract int getContentViewId();

    public ViewGroup getRootView() {
        return rootView;
    }


    /**
     * 显示进度框
     */
    protected void showProgress() {
        waitProgressDialog = new LoadingDialog(this).setMessage("正在加载...");
        waitProgressDialog.show();
    }

    /**
     * 隐藏进度框
     */
    protected void dismissProgress() {
        if (waitProgressDialog != null) {
            waitProgressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }


}
