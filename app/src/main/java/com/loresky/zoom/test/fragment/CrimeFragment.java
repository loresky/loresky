package com.loresky.zoom.test.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.loresky.zoom.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/3/2.
 */
public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitlel;
    private TextView mDate;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable("aa");
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);
        mTitlel = (EditText) view.findViewById(R.id.crime_title);
        mDate = (TextView) view.findViewById(R.id.tv_date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd");
        Date date = new Date(System.currentTimeMillis());
        mDate.setText("" + format.format(date));


        return view;
    }
    public static CrimeFragment newInstance(UUID crimeId)
    {
        Bundle args = new Bundle();
        args.putSerializable("aa", crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
