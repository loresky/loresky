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

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/3.
 */
public class HttpPostAcitvity extends BaseActivity implements View.OnClickListener {

    private TextView tv;
    private Button mBtn;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constants.HandlerId.HTTP_SUCCESS:
                    tv.setText(msg.getData().getString("restult"));
                    Toast.makeText(HttpPostAcitvity.this, "请求成功", Toast.LENGTH_LONG).show();
                    break;
                case Constants.HandlerId.HTTP_FAILURE:
                    tv.setText(msg.getData().getString("erro"));
                    Toast.makeText(HttpPostAcitvity.this, "请求失败", Toast.LENGTH_LONG).show();
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
        tv.setText("httpPost");
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
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new Thread() {
            @Override
            public void run() {
                httpPostEvent();
            }
        }.start();
    }

    private void httpPostEvent() {
        BufferedReader in = null;
        try {
            HttpClient client = new DefaultHttpClient();
            // 请求超时
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
            // 读取超时
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);

            HttpPost request = new HttpPost("http://112.124.12.201/longtimefind/login.do?jsonstr=");
            List<NameValuePair> postParmeters = new ArrayList<NameValuePair>();
            postParmeters.add(new BasicNameValuePair("usershortname", "13866666666"));
            postParmeters.add(new BasicNameValuePair("password", "123456"));
            postParmeters.add(new BasicNameValuePair("usertype", "0"));

            UrlEncodedFormEntity urlEncoded = new UrlEncodedFormEntity(postParmeters, "utf-8");
            request.setEntity(urlEncoded);

            HttpResponse response = client.execute(request);
            int restultId = response.getStatusLine().getStatusCode();
            DebugLog.i("" + restultId);
            if (restultId == HttpStatus.SC_OK) {
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
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
        }
    }
}
