package com.loresky.zoom.test.glide;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loresky.zoom.R;
import com.loresky.zoom.common.BaseActivity;
import com.loresky.zoom.util.DebugLog;

/**
 * Created by cy on 15-4-23.
 */
public class GlideActivity extends BaseActivity implements OnClickListener {
    private Button requestBtn;
    private ImageView mImage;

    @Override
    public void loadContentView() {
        setContentView(R.layout.activity_glide);
    }

    @Override
    public void initViews() {
        requestBtn = (Button) findViewById(R.id.request);
        mImage = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        requestBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.request:
                loadImage();
                break;
        }
    }

    private void loadImage() {
        String url = "http://d.hiphotos.baidu.com/image/pic/item/08f790529822720ea751464078cb0a46f31fabe9.jpg";
        Glide.with(this).load(url)
                .override(300,200)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.abc_ab_share_pack_mtrl_alpha)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(mImage);
    }
}
