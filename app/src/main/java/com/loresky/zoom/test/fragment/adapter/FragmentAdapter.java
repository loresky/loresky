package com.loresky.zoom.test.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loresky.zoom.R;
import com.loresky.zoom.test.fragment.Crime;

import java.util.ArrayList;

/**
 * @Company: guangpai
 * @Title: FragmentAdapter.java
 * @Description: 描述
 * @author: chenyong
 * @date: 2015年2月14日
 * @version: 1.0
 */

public class FragmentAdapter extends BaseAdapter
{
	private LayoutInflater mInflater;
	private ArrayList<Crime> mcrArrayList;

	public FragmentAdapter(Context mContext, ArrayList<Crime> mcrArrayList)
	{
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mcrArrayList = mcrArrayList;

	}

	public int getCount()
	{
		return mcrArrayList.size();
	}

	public Object getItem(int position)
	{
		return mcrArrayList.get(position);
	}

	public long getItemId(int position)
	{
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		Holder holder = null;
		if (convertView == null)
		{
			holder = new Holder();
			convertView = mInflater.inflate(R.layout.item_crime, parent, false);
			holder.tv = (TextView) convertView.findViewById(R.id.tv);
		} else
		{
			holder = (Holder) convertView.getTag();
		}
		holder.tv.setText("" + mcrArrayList.get(position).getId());
		return convertView;
	}

	private static class Holder
	{
		public static TextView tv;
	}
}
