package com.loresky.zoom.test.dialogfragment;

import android.app.Activity;
import android.os.Bundle;

import com.loresky.zoom.R;
import com.loresky.zoom.common.BaseActivity;

/**
 * Created by Administrator on 2015/3/2.
 */
public class MyDialogFragment extends BaseActivity {

    @Override
    public void loadContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {
        AlterDialogFragment adf = new AlterDialogFragment();
        adf.show(getFragmentManager(), "dialog");
    }

    @Override
    public void setListener() {

    }
}
