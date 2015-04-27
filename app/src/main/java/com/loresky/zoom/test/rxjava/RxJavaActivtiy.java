package com.loresky.zoom.test.rxjava;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.loresky.zoom.common.BaseActivity;
import com.loresky.zoom.util.DebugLog;



/**
 * Created by cy on 15-4-24.
 */
public class RxJavaActivtiy extends BaseActivity implements OnClickListener{
    private Button mBtn;

    @Override
    public void loadContentView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        mBtn = new Button(this);
        mBtn.setText("请求");
        linearLayout.addView(mBtn);
        setContentView(linearLayout);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        aaa();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onClick(View v) {
        DebugLog.v("==================aaa");
    }

    private void aaa() {

//        ViewObservable.clicks(mBtn).subscribe();
    }
}
