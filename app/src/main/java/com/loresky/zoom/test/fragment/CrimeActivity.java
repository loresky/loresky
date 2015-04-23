package com.loresky.zoom.test.fragment;

import android.support.v4.app.Fragment;

import com.loresky.zoom.test.fragment.abs.SingleFragmentActivity;

import java.util.UUID;

/**
 * Created by 312 on 2015/3/12.
 */
public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID)getIntent().getSerializableExtra("aa");
        return  CrimeFragment.newInstance(crimeId);
    }
}
