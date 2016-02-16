package com.example.broadcastbestpractice;



import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity {
	
	private IntentFilter intentFilter;
	
	private ForceOfflineReceiver forceOfflineReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intentFilter=new IntentFilter();
		intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE");
		forceOfflineReceiver=new ForceOfflineReceiver();
		registerReceiver(forceOfflineReceiver,intentFilter);
		
		Button forceOffline=(Button)findViewById(R.id.force_offline);
		forceOffline.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
				sendBroadcast(intent);
			}
			
			
		});
	}
}
