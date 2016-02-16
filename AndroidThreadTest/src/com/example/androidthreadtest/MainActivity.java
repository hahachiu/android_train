package com.example.androidthreadtest;

import android.app.Activity;
import android.os.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener{

	public static final int UPDATE_TEXT=1;
	
	private Handler handler=new Handler(){
		
		
		public void handleMessage(Message msg){
			switch(msg.what){
			case UPDATE_TEXT:
				text.setText("Nice to meet you");
				break;
			default:
				break;
			}
		}
		
	};
	
	private TextView text;
	
	private Button changeText;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text=(TextView)findViewById(R.id.text);
		changeText=(Button)findViewById(R.id.change_text);
		changeText.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch(v.getId()){
		case R.id.change_text:
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					Message message=new Message();
					message.what=UPDATE_TEXT;
					handler.sendMessage(message);
				}
				
			}).start();
			break;
		default:
			break;
		
		}
	}
}
