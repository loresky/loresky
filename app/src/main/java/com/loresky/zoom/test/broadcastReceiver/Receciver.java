package com.loresky.zoom.test.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @COMPANY: loresky
 * @DESCRIPTION: 接收广播
 * @AUTHOR: cy
 * @VERSION: v1.0.0
 * @DATE: 2015-03-04
 */
public class Receciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Toast.makeText(context, bundle.getString("name"), Toast.LENGTH_LONG).show();
    }
}
