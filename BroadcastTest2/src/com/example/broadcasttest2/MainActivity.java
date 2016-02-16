package com.example.broadcasttest2;

import android.app.Activity;
import android.content.*;
import android.net.*;
import android.os.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {
	
	private AnotherBroadcastReceiver anotherBroadcastReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	@Override
	protected void onDestroy(){
		
		super.onDestroy();
		unregisterReceiver(anotherBroadcastReceiver);
		
	}
	
	
}
