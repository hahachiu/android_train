package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO �Զ����ɵķ������
		Toast.makeText(context, "Boot Complete", Toast.LENGTH_SHORT).show();
	}

}
