package com.example.notificationtest;

import java.io.File;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button sendNotice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendNotice=(Button)findViewById(R.id.send_notice);
		sendNotice.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch(v.getId()){
		case R.id.send_notice:
			NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			Intent intent =new Intent(this,NotificationActivity.class);
			PendingIntent pi=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
			Notification notification = new Notification.Builder(getBaseContext())    
	         .setAutoCancel(true)
	         .setContentTitle("This is content title")  
	         .setContentText("This is content text")
	         .setContentIntent(pi)
	         .setSmallIcon(R.drawable.ic_launcher)
	         .setWhen(System.currentTimeMillis())
	         .build();
			Uri soundUri=Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"));
			notification.sound=soundUri;
			long[] vibrates={0,1000,1000,1000};
			notification.vibrate=vibrates;
			manager.notify(1,notification);
			break;
		default:
			break;
		}
	}
}
