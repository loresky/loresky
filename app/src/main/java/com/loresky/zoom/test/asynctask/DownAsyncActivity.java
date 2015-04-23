package com.loresky.zoom.test.asynctask;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loresky.zoom.R;
import com.loresky.zoom.common.BaseActivity;

/**
 * Created by Administrator on 2015/3/3.
 */
public class DownAsyncActivity extends BaseActivity implements OnClickListener {
    private Button btn;
    private ProgressBar mProgressBar;
    private TextView mTitle;

    @Override
    public void loadContentView() {
        setContentView(R.layout.down_async);
    }

    @Override
    public void initViews() {
        mTitle = (TextView) findViewById(R.id.tv);
        mProgressBar = (ProgressBar) findViewById(R.id.pBar);
        btn = (Button) findViewById(R.id.btn);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                DownAsyncTask downAsync = new DownAsyncTask(mTitle, mProgressBar);
                downAsync.execute(100);
                break;
            default:

                break;
        }
    }
}
