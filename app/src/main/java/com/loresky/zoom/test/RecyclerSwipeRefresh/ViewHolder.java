package com.loresky.zoom.test.RecyclerSwipeRefresh;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.loresky.zoom.R;
import com.orhanobut.logger.Logger;


/**
 * Created by cy on 15-5-6.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;


    public ViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("onClick_Textview");
            }
        });
        textView = (TextView) itemView.findViewById(R.id.textView);
    }

    public TextView getTextView() {
        return textView;
    }
}
