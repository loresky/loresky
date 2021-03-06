package com.loresky.zoom.test.fragment.abs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.loresky.zoom.R;

/**
 * Created by Administrator on 2015/3/2.
 */
public abstract class SingleFragmentActivity extends FragmentActivity
{
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle arg0)
    {
        super.onCreate(arg0);
        setContentView(R.layout.activity_crime);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null)
        {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }

}
