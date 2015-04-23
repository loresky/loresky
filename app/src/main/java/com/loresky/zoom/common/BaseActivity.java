package com.loresky.zoom.common;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.loresky.zoom.util.ToastMessage;

/**
 * Created by Administrator on 2015/2/27.
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        loadContentView();
        initViews();
        initData();
        setListener();
    }

    /**
     * 初始化界面
     */
    public abstract void loadContentView();

    /**
     * 初始化控件
     */
    public abstract void initViews();

    /**
     * 初始化信息
     */
    public abstract void initData();

    /**
     * 设置事件监听事件
     */
    public abstract void setListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast关闭提示
        ToastMessage.closd();
        //结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }
}
