package com.loresky.zoom.test.glide;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gc.materialdesign.views.ButtonRectangle;
import com.loresky.zoom.R;
import com.loresky.zoom.common.BaseActivity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cy on 15-4-23.
 */
public class GlideActivity extends BaseActivity {
    private ButtonRectangle requestBtn;
    private ButtonRectangle request_sd_Btn;
    private ImageView mImage;

    private List<String> img_path = new ArrayList<String>();

    @Override
    public void loadContentView() {
        setContentView(R.layout.activity_glide);
    }

    @Override
    public void initViews() {
        requestBtn = (ButtonRectangle) findViewById(R.id.request);
        request_sd_Btn = (ButtonRectangle) findViewById(R.id.request_sd);
        mImage = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void initData() {
        getSdImageUrl();
    }

    @Override
    public void setListener() {
        requestBtn.setOnClickListener(v -> loadImage());
        request_sd_Btn.setOnClickListener(v -> loadSdImage());
    }

    private void loadImage() {
        String url = "http://d.hiphotos.baidu.com/image/pic/item/08f790529822720ea751464078cb0a46f31fabe9.jpg";
        Glide.with(this).load(url)
                //                .override(300,200)
                //                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.abc_ab_share_pack_mtrl_alpha)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(mImage);
    }

    private void loadSdImage() {
        Glide.with(this).load(img_path.get(0))
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.abc_ab_share_pack_mtrl_alpha)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(mImage);
    }

    private void getSdImageUrl() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "暂无外部存储", Toast.LENGTH_SHORT).show();
            return;
        }

        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = getContentResolver();

        //只查询jpeg和png的图片
        Cursor mCursor = mContentResolver.query(mImageUri, null,
                MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED);

        while (mCursor.moveToNext()) {
            //获取图片的路径
            String path = mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA));
            img_path.add("file://" + path);
        }
        mCursor.close();
        Logger.d("sd卡里图片数量:" + img_path.size());
    }
}
