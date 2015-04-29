package com.loresky.zoom;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loresky.zoom.common.BaseActivity;
import com.loresky.zoom.daoexample.GeenDaoActivity;
import com.loresky.zoom.test.asynctask.DownAsyncActivity;
import com.loresky.zoom.test.broadcastReceiver.RececiverActivity;
import com.loresky.zoom.test.dialogfragment.MyDialogFragment;
import com.loresky.zoom.test.fragment.CrimeActivity;
import com.loresky.zoom.test.fragment.CrimeListActivity;
import com.loresky.zoom.test.glide.GlideActivity;
import com.loresky.zoom.test.httpclient.HttpGetActivity;
import com.loresky.zoom.test.httpclient.HttpPostAcitvity;
import com.loresky.zoom.test.iconfont.IconFontActivity;
import com.loresky.zoom.test.notification.NotificationActivity;
import com.loresky.zoom.test.photoview.PhotoViewAcitvity;
import com.loresky.zoom.test.rxjava.RxJavaActivtiy;
import com.loresky.zoom.test.volley.VolleyActivity;
import com.loresky.zoom.util.DebugLog;

public class MainActivity extends BaseActivity implements OnItemClickListener {
    private ListView mListView;

    private Class[] mClass = new Class[]
            {CrimeActivity.class, CrimeListActivity.class,
                    MyDialogFragment.class, DownAsyncActivity.class,
                    HttpGetActivity.class, HttpPostAcitvity.class,
                    RececiverActivity.class, GeenDaoActivity.class,
                    VolleyActivity.class, NotificationActivity.class,
                    IconFontActivity.class, GlideActivity.class,
                    RxJavaActivtiy.class, PhotoViewAcitvity.class
            };

    private String[] mName = new String[]{
            "fragment", "listFragment",
            "dialogFragment", "asyncTask",
            "httpGet", "httpPost",
            "RececiverActivity", "GeenDao",
            "Volley", "Notification",
            "inco font", "glide图片加载",
            "RxJavaActivtiy", "PhotoView"
    };

    @Override
    public void loadContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initViews() {
        mListView = (ListView) findViewById(R.id.list_view);
    }

    @Override
    public void initData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, mName);
        mListView.setAdapter(adapter);
    }

    @Override
    public void setListener() {
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                startActivity(new Intent(this, SplashActivity.class));
                finish();
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DebugLog.i("id:" + position);
        startActivity(new Intent(this, mClass[position]));
    }
}
