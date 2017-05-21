package com.tangpeng.dailydemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangpeng.dailydemo.utils.AutoUtils;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by tangpeng on 2017/5/21.
 */

public abstract class BaseFragment extends Fragment {
    protected CompositeSubscription mCompositeSubscription;
    private boolean isEventBusBind;
    private View rootView;
    protected String TAG;
    private BaseActivity activity;
    private View contentView;
    private ViewGroup container;


    protected LayoutInflater inflater;
    private Context mContext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isAdded()) {
            mContext = getContext();
        }
        //配置Rxjava
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        TAG = this.getClass().getSimpleName();
        activity = ((BaseActivity) getActivity());

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        if (container != null) {
            setContentView(setLayoutId());
            AutoUtils.auto(contentView);
        }
        initView();
        return contentView;

    }

    public void setContentView(int layoutResID) {
        setContentView(inflater.inflate(layoutResID, container, false));
    }

    public void setContentView(View view) {
        contentView = view;
    }

    public View findViewById(int id) {
        if (contentView != null)
            return contentView.findViewById(id);
        return null;
    }

    public abstract int setLayoutId();


    public abstract void initView();


    @Override
    public void onDestroy() {
        super.onDestroy();
        contentView = null;
        container = null;
        inflater = null;

        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }


}

