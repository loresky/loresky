package com.loresky.zoom.test.dialogfragment;

import com.loresky.zoom.R;
import com.loresky.zoom.common.BaseActivity;

/**
 * @COMPANY: loresky
 * @DESCRIPTION: DialogFragment
 * @AUTHOR: cy
 * @VERSION: v1.0.0
 * @DATE: 2015-03-02
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
