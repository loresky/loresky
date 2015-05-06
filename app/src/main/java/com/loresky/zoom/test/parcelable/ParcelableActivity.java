package com.loresky.zoom.test.parcelable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cy on 15-5-6.
 */
public class ParcelableActivity extends Activity {
    private List<ParcelableDeveloper.Skill> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Button mBtn = new Button(this);

        linearLayout.addView(mBtn);
        setContentView(linearLayout);

        mList = new ArrayList<ParcelableDeveloper.Skill>();

        mBtn.setOnClickListener(v -> {

            ParcelableDeveloper.Skill skill = new ParcelableDeveloper.Skill();
            skill.setName("111");
            skill.setProgrammingRelated(true);
            mList.add(skill);

            ParcelableDeveloper parcel = new ParcelableDeveloper();
            parcel.setName("aaa");
            parcel.setYearsOfExperience(2015);
            parcel.setSkillSet(mList);

            Intent intent = new Intent(ParcelableActivity.this, AcceptAcitvity.class);
            intent.putExtra("parcels", parcel);
            startActivity(intent);
        });
    }
}
