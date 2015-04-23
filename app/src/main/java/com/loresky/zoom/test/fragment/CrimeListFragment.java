package com.loresky.zoom.test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.loresky.zoom.MainActivity;
import com.loresky.zoom.test.fragment.adapter.FragmentAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/3/2.
 */
public class CrimeListFragment extends ListFragment
{
    private ArrayList<Crime> mArrayList;
    private FragmentAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("一个好人");
        mArrayList = CrimeLab.get(getActivity()).getCrimes();
        mAdapter = new FragmentAdapter(getActivity(), mArrayList);
        setListAdapter(mAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        Crime crime = (Crime) mAdapter.getItem(position);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("aa", "aaa");
        startActivity(intent);
    }
}
