package com.example.localbroadcasttest;


import android.app.Activity;
import android.content.*;
import android.net.*;
import android.os.*;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {
	
	private IntentFilter intentFilter1;
	
	private LocalBroadcastManager localBroadcastManager;
	
	private LocalReceiver localReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		localBroadcastManager=LocalBroadcastManager.getInstance(this);

		Button button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent("com.example.localbroadcasttest.LOCAL_BROADCAST");
				localBroadcastManager.sendBroadcast(intent);
				
			}
			
		});
		
		intentFilter1=new IntentFilter();
		intentFilter1.addAction("com.example.localbroadcasttest.LOCAL_BROADCAST");
		localReceiver=new LocalReceiver();
		localBroadcastManager.registerReceiver(localReceiver,intentFilter1);
	}
	
	@Override
	protected void onDestroy(){
		
		super.onDestroy();
		localBroadcastManager.unregisterReceiver(localReceiver);
		
	}
	
	

	
	class LocalReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO 自动生成的方法存根
			Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
		}
		
	}
	
}