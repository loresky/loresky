package com.loresky.zoom.common;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.loresky.zoom.util.ToastMessage;

/**
 * @COMPANY: loresky
 * @DESCRIPTION: 应用程序Activity基类
 * @AUTHOR: cy
 * @VERSION: v1.0.0
 * @DATE: 2015-03-03
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onStart() {
        super.onStart();
        AppForegroundStateManager.getInstance().onActivityVisible(this);
    }

    @Override
    protected void onStop() {
        AppForegroundStateManager.getInstance().onActivityNotVisible(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast关闭提示
        ToastMessage.closd();
        //结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }

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


}
