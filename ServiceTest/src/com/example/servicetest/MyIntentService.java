package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

	public MyIntentService() {
		super("MyIntentService");
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO 自动生成的方法存根
		Log.d("MyIntentServce", "Thread id is "+Thread.currentThread().getId());
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.d("MyIntentService", "onDestroy executed");
	}

}
