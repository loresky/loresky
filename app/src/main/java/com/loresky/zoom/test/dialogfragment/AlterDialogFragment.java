package com.loresky.zoom.test.dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.loresky.zoom.R;

/**
 * @COMPANY: loresky
 * @DESCRIPTION: AlterDialogFragment
 * @AUTHOR: cy
 * @VERSION: v1.0.0
 * @DATE: 2015-03-02
 */
public class AlterDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //去标题栏
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.fragmetn_dialog, container);
        Button btn = (Button) view.findViewById(R.id.id_sure_edit_name);

        btn.setOnClickListener(v -> dismiss());
        return view;
    }
}
