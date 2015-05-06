package com.loresky.zoom.test.RecyclerSwipeRefresh;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.loresky.zoom.R;

import java.util.List;

/**
 * Created by cy on 15-5-6.
 */
public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<String> mList;

    public CustomAdapter(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_row_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getTextView().setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
