package com.loresky.zoom;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.loresky.zoom.common.BaseActivity;
import com.loresky.zoom.util.DebugLog;

import java.util.List;

public class MainActivity extends BaseActivity implements OnItemClickListener {
    private ListView mListView;
    private List<String> mList;

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
//        mList = new ArrayList<String>();
//
//        String dirs[] = getResources().getStringArray(R.array.dri);
//        for (String s : dirs) {
//            mList.add(s);
//        }
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mList);
//
//        mListView.setAdapter(adapter);
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
//        Class classFlag = null;
//        switch (position) {
//            case 0:
//                classFlag = CrimeActivity.class;
//                break;
//            case 1:
//                classFlag = CrimeListActivity.class;
//                break;
//            case 2:
//                classFlag = MyDialogFragment.class;
//                break;
//            case 3:
//                classFlag = DownAsyncActivity.class;
//                break;
//            case 4:
//                classFlag = HttpGetActivity.class;
//                break;
//            case 5:
//                classFlag = HttpPostAcitvity.class;
//                break;
//            case 6:
//                classFlag = RececiverActivity.class;
//                break;
//            case 7:
//                classFlag = GeenDaoActivity.class;
//                break;
//            case 8:
//                classFlag = VolleyActivity.class;
//                break;
//            case 9:
//                classFlag =NotificationActivity.class;
//                break;
//            case 10:
//                classFlag=IconFontActivity.class;
//                break;
//            default:
//                break;
//        }
//        startActivity(new Intent(this, classFlag));
    }
}
