package com.loresky.zoom.test.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * https://github.com/bumptech/glide/wiki/Configuration
 * 设置Glide内存、缓存大小、显示格式
 * <p>
 * 要在AndroidManifest.xml添加
 * <meta-data
 * android:name="com.loresky.zoom.test.glide.MyGlideModule"
 * android:value="GlideModule" />
 */
public class MyGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //设置图片格式
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //设置缓存目录、大小
        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                File cacheLocation = new File(context.getExternalCacheDir(), "cache_dir_name");
                cacheLocation.mkdirs();
                return DiskLruCacheWrapper.get(cacheLocation, 250 * 1024 * 1024);
            }
        });
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
