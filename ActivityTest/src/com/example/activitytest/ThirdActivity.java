package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("ThirdActivity","Task id is " +getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
		
		//销毁所有活动
		Button button3=(Button)findViewById(R.id.button_3);
		button3.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				ActivityCollector.finishAll();
			}
		});
	}
}
