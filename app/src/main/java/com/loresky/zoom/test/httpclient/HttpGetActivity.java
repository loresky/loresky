package com.loresky.zoom.test.httpclient;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loresky.zoom.common.BaseActivity;
import com.loresky.zoom.common.Constants;
import com.loresky.zoom.util.DebugLog;
import com.loresky.zoom.util.ToastMessage;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ResponseCache;

/**
 * Created by Administrator on 2015/3/3.
 */
public class HttpGetActivity extends BaseActivity {
    private TextView tv;
    private Button mBtn;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constants.HandlerId.HTTP_SUCCESS:
                    tv.setText("请求成功:"+msg.getData().getString("restult"));
                    Toast.makeText(HttpGetActivity.this, "请求成功", Toast.LENGTH_LONG).show();
                    break;
                case Constants.HandlerId.HTTP_FAILURE:
                    tv.setText("请求失败:"+msg.getData().getString("erro"));
                    Toast.makeText(HttpGetActivity.this, "请求失败", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;

            }
        }
    };

    @Override
    public void loadContentView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        tv = new TextView(this);
        tv.setText("httpGet");
        mBtn = new Button(this);
        mBtn.setText("请求");
        linearLayout.addView(tv);
        linearLayout.addView(mBtn);
        setContentView(linearLayout);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        httpGetEvent();
                    }
                }.start();
            }
        });
    }

    private void httpGetEvent() {
        BufferedReader in = null;
        try {
            HttpClient client = new DefaultHttpClient();
            // 请求超时
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
            // 读取超时
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);

            HttpGet request = new HttpGet("http://www.baidu.com");
            HttpResponse response = client.execute(request);
            int restultId = response.getStatusLine().getStatusCode();
            if (restultId == HttpStatus.SC_OK) {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                DebugLog.i(sb.toString());
                in.close();
                Message msg = mHandler.obtainMessage(Constants.HandlerId.HTTP_SUCCESS);
                Bundle data = new Bundle();
                data.putString("restult", sb.toString());
                msg.setData(data);
                msg.sendToTarget();
            } else {
                Message msg = mHandler.obtainMessage(Constants.HandlerId.HTTP_FAILURE);
                Bundle data = new Bundle();
                data.putString("erro", String.valueOf(restultId));
                msg.setData(data);
                msg.sendToTarget();
            }
        } catch (IOException e) {
            e.printStackTrace();
            DebugLog.e(e.getLocalizedMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                DebugLog.e(e.getLocalizedMessage());
            }
        }
    }

}
