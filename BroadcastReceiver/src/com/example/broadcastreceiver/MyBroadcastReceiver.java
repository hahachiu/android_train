package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO 自动生成的方法存根
		Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show();
		abortBroadcast();
	}

}
