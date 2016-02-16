package com.example.uiwidgetest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UIWidgetestActivity extends Activity implements OnClickListener{
	private Button button;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uiwidgetest_layout);
		button=(Button)findViewById(R.id.button);
		editText=(EditText)findViewById(R.id.edit_Text);
		imageView=(ImageView)findViewById(R.id.image_View);
		progressBar=(ProgressBar)findViewById(R.id.progress_Bar);
		button.setOnClickListener(this);
		//匿名类监听器
		/*button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//在此处添加逻辑
			}
		});*/
	}
	
	
	@Override
	public void onClick(View v){
		
		switch(v.getId()){
		case R.id.button:
			ProgressDialog progressDialog=new ProgressDialog(UIWidgetestActivity.this);
			progressDialog.setTitle("This is ProgressDialog");
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(true);
			progressDialog.show();
			
			
			
			/*AlertDialog.Builder dialog=new AlertDialog.Builder(UIWidgetestActivity.this);
			dialog.setTitle("This is Dialog");
			dialog.setMessage("something important.");
			dialog.setCancelable(false);
			dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO 自动生成的方法存根
					
				}
			});
			dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO 自动生成的方法存根
					
				}
			});
			dialog.show();*/
			
			
			
			/*int progress=progressBar.getProgress();
			progress=progress+10;
			progressBar.setProgress(progress);*/
			
			
			
			/*if(progressBar.getVisibility()==View.GONE){
				progressBar.setVisibility(View.VISIBLE);
			}
			else{
				progressBar.setVisibility(View.GONE);
			}*/
			
			
			
			//imageView.setImageResource(R.drawable.ic_launcher);
			
			
			
			//String inputText=editText.getText().toString();
			//Toast.makeText(UIWidgetestActivity.this, inputText, Toast.LENGTH_SHORT).show();
			//在此添加逻辑
			break;
		default:
			break;
		}
	}
	
	
	
	
}
