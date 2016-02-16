package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//Log.d("FirstActivity",this.toString());
		Log.d("FirstActivity", "Task id is "+getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1=(Button)findViewById(R.id.Button_1);
		button1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(FirstActivity.this,"You clicked Button 1" , Toast.LENGTH_SHORT).show();
				//显式intent
				Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
				//隐式intent
				/*Intent intent=new Intent("com.example.activitytest.ACTION_START");
				intent.addCategory("com.example.activitytest.MY_CATEGORY");*/
				/*Intent intent=new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://baidu.com"));*/
				/*Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));*/
				//intent传递数据
				/*String data ="Hello SecondActivity";
				intent.putExtra("extra_data", data);*/
				/*startActivityForResult(intent,1);*/
				//活动启动模式-standard
				/*Intent intent=new Intent(FirstActivity.this,FirstActivity.class);*/
				startActivity(intent);
			}
		});
	}
	
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
			case R.id.add_item:
				Toast.makeText(FirstActivity.this,"You clicked Add" , Toast.LENGTH_SHORT).show();
				break;
			case R.id.remove_item:
				Toast.makeText(FirstActivity.this,"You clicked Remove" , Toast.LENGTH_SHORT).show();
				break;
			default:
		}
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		switch(requestCode){
		case 1:
			if(resultCode==RESULT_OK){
				String returnedData=data.getStringExtra("data_return");
				Log.d("FirstActvity",returnedData);
			}
			break;
		default:
		}
	}
	
	@Override
	public void onBackPressed(){
		Intent intent=new Intent();
		intent.putExtra("data_return", "Hello FirstActivity");
		setResult(RESULT_OK,intent);
		finish();
	}
	
	@Override
	protected void onRestart(){
		super.onRestart();
		Log.d("FirstActivity", "onRestart");
	}
	
	
}













