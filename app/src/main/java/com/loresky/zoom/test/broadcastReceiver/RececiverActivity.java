package com.loresky.zoom.test.broadcastReceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.loresky.zoom.common.BaseActivity;

/**
 * @COMPANY: loresky
 * @DESCRIPTION: Rececive广播
 * @AUTHOR: cy
 * @VERSION: v1.0.0
 * @DATE: 2015-03-04
 */
public class RececiverActivity extends BaseActivity implements View.OnClickListener {
    private Button mBtn;

    @Override
    public void loadContentView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        mBtn = new Button(this);
        mBtn.setText("发送广播");
        linearLayout.addView(mBtn);
        setContentView(linearLayout);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        //生成广播处理
        Receciver receciver = new Receciver();
        //实例化过滤器并设置要过滤的广播
        IntentFilter intentFilter = new IntentFilter("com.loresyk.zoom.one");
        //注册广播
        registerReceiver(receciver, intentFilter);
    }

    @Override
    public void setListener() {
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        //可以接收到广播(已经注册 com.loresyk.zoom.one)
        intent.setAction("com.loresyk.zoom.one");
        //接收不到广播(未注册 com.loresyk.zoom.two)
//        intent.setAction("com.loresyk.zoom.two");
        Bundle bundle = new Bundle();
        bundle.putString("name", getClass().toString());
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }
}
