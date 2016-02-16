package com.example.broadcastreceiver;

import android.app.Activity;
import android.content.*;
import android.net.*;
import android.os.*;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {
	
	private IntentFilter intentFilter;
	
	private NetworkChangeReceiver networkChangeReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		intentFilter=new IntentFilter();
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		networkChangeReceiver=new NetworkChangeReceiver();
		registerReceiver(networkChangeReceiver,intentFilter);
		
		Button button=(Button)findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
				Intent intent=new Intent("com.example.broadcastreceiver.MY_BROADCAST");
				sendOrderedBroadcast(intent,null);
				
			}
			
		});
		
	}
	
	@Override
	protected void onDestroy(){
		
		super.onDestroy();
		unregisterReceiver(networkChangeReceiver);
		
	}
	
	
	class NetworkChangeReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO 自动生成的方法存根
			
			ConnectivityManager connectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo=connectionManager.getActiveNetworkInfo();
			if(networkInfo!=null&&networkInfo.isAvailable()){
				Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
			}
			
		}
		
		
	}
	
	
}
