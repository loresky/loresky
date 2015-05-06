package com.loresky.zoom.test.parcelable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

/**
 * Created by cy on 15-5-6.
 */
public class AcceptAcitvity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView mText = new TextView(this);
        linearLayout.addView(mText);
        setContentView(linearLayout);

        Intent intent = getIntent();
        ParcelableDeveloper parcelable = intent.getParcelableExtra("parcels");

        ParcelableDeveloper.Skill skill = parcelable.getSkillSet().get(0);

        Logger.d(parcelable.getName() + "       " + parcelable.getYearsOfExperience());
        Logger.d(skill.getName() + "       " + skill.programmingRelated);

        mText.setText(parcelable.getName() + "  " + parcelable.getYearsOfExperience() + "\n" + skill.getName() + "  " + skill.programmingRelated);

    }
}
