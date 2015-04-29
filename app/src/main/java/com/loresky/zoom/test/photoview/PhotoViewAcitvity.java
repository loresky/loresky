package com.loresky.zoom.test.photoview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.loresky.zoom.R;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by cy on 15-4-29.
 */
public class PhotoViewAcitvity extends Activity {
    private ImageView mImageView;
    private PhotoViewAttacher mAttarcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phototview);

        mImageView = (ImageView) findViewById(R.id.iv_photo);
        mAttarcher = new PhotoViewAttacher(mImageView);
        mAttarcher.update();
    }
}
