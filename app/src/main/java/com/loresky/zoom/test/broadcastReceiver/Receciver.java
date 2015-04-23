package com.loresky.zoom.test.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/3/4.
 */
public class Receciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Toast.makeText(context, bundle.getString("name"), Toast.LENGTH_LONG).show();
    }
}
