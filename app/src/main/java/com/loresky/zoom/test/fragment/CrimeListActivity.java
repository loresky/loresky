package com.loresky.zoom.test.fragment;

import android.support.v4.app.Fragment;

import com.loresky.zoom.test.fragment.abs.SingleFragmentActivity;

import java.util.UUID;

/**
 * Created by Administrator on 2015/3/2.
 */
public class CrimeListActivity extends SingleFragmentActivity
{

    @Override
    protected Fragment createFragment()
    {
        UUID crimeId = (UUID)getIntent().getSerializableExtra("aa");
//        return  CrimeFragment.newInstance(crimeId);
        return new CrimeListFragment();
    }


}