package com.example.filepersistencetest;


import java.io.*;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;



public class MainActivity extends Activity {
	
	private EditText edit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit=(EditText)findViewById(R.id.edit);
		
		
		String inputText=load();
		if(!TextUtils.isEmpty(inputText)){
			edit.setText(inputText);
			edit.setSelection(inputText.length());
			Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show();
		}
	}
	



	protected void onDestroy(){
		super.onDestroy();
		String inputText=edit.getText().toString();
		save(inputText);
		
	}


	public void save(String inputText) {
		// TODO 自动生成的方法存根
		FileOutputStream out=null;
		BufferedWriter writer=null;
		try{
			out=openFileOutput("data",Context.MODE_PRIVATE);
			writer=new BufferedWriter(new OutputStreamWriter(out));
			writer.write(inputText);
			
		}catch(IOException e){
			e.printStackTrace();
			
		}finally{
			try{
				if(writer!=null){
					writer.close();
				}
			}catch(IOException e){
				e.printStackTrace();
				
			}
			
		}
	}
	
	
	

	private String load() {
		// TODO 自动生成的方法存根
		
		FileInputStream in=null;
		BufferedReader reader=null;
		StringBuilder content=new StringBuilder();
		try{
			in=openFileInput("data");
			reader=new BufferedReader(new InputStreamReader(in));
			String line="";
			while((line=reader.readLine())!=null){
				content.append(line);
			}
			
		}catch(IOException e){
			e.printStackTrace();
			
		}finally{
			try{
				if(reader!=null){
					reader.close();
				}
			}catch(IOException e){
				e.printStackTrace();
				
			}
			
		}
		return content.toString();
	}
}