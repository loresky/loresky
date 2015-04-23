package com.loresky.zoom.test.volley;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loresky.zoom.R;
import com.loresky.zoom.common.BaseActivity;
import com.loresky.zoom.util.DebugLog;


/**
 * Created by Administrator on 2015/3/9.
 */
public class VolleyActivity extends BaseActivity implements OnClickListener {
    private Button httpRequest;

    @Override
    public void loadContentView() {
        setContentView(R.layout.activity_vollye);

    }

    @Override
    public void initViews() {
        httpRequest = (Button) findViewById(R.id.request);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        httpRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.request:
                httpRequest();
                break;
            default:
                break;
        }
    }

    private void httpRequest() {
        DebugLog.i("httpRequest()");
        RequestQueue mQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        DebugLog.i("response:" + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                DebugLog.e("error" + error.getMessage());
            }
        });
        mQueue.add(stringRequest);
        mQueue.start();

    }
}
