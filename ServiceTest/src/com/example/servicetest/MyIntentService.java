package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

	public MyIntentService() {
		super("MyIntentService");
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO �Զ����ɵķ������
		Log.d("MyIntentServce", "Thread id is "+Thread.currentThread().getId());
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		Log.d("MyIntentService", "onDestroy executed");
	}

}
