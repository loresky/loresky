package com.loresky.zoom.test.iconfont;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.loresky.zoom.R;

/**
 * Created by 312 on 2015/3/16.
 */
public class IconFontActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_font);

        Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont/iconfont.ttf");
        TextView textview = (TextView) findViewById(R.id.like);
        textview.setTypeface(iconfont);
        textview.setTextSize(40);

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setTypeface(iconfont);
        tv.setTextSize(40);
        tv.setText("\u3605");
        tv.setTextColor(Color.RED);

    }
}
