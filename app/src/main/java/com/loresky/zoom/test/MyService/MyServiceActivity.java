package com.loresky.zoom.test.MyService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.orhanobut.logger.Logger;

import rx.android.view.OnClickEvent;
import rx.android.view.ViewObservable;
import rx.functions.Action1;

/**
 * Created by cy on 15-5-8.
 */
public class MyServiceActivity extends Activity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private MyService mService;

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Logger.d("random", "===onServiceConnected()===");
            mService = ((MyService.myBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Logger.d("random", "===onServiceDisconnected()===");
            mService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mLinearLayout = new LinearLayout(this);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        btn1 = new Button(this);
        btn2 = new Button(this);
        btn3 = new Button(this);
        btn4 = new Button(this);
        btn1.setText("开启服务");
        btn2.setText("关闭服务");
        btn3.setText("绑定服务");
        btn4.setText("解绑服务");
        mLinearLayout.addView(btn1);
        mLinearLayout.addView(btn2);
        mLinearLayout.addView(btn3);
        mLinearLayout.addView(btn4);
        setContentView(mLinearLayout);

        ViewObservable.clicks(btn1).subscribe(mAction1);
    }

    private Action1<OnClickEvent> mAction1 = new Action1<OnClickEvent>() {
        @Override
        public void call(OnClickEvent onClickEvent) {
            Intent intent = new Intent(MyServiceActivity.this, MyService.class);
            if (onClickEvent.view() == btn1) {
                startService(intent);
            } else if (onClickEvent.view() == btn2) {
                stopService(intent);
            } else if (onClickEvent.view() == btn3) {
                bindService(intent, mConnection, BIND_AUTO_CREATE);
            } else if (onClickEvent.view() == btn4) {
                unbindService(mConnection);
            }
        }
    };
}
