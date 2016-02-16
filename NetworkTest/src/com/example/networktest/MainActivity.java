package com.example.networktest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.SAXParserFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	public static final int SHOW_RESPONSE=0;
	
	private Button sendRequest;
	
	private TextView responseText;
	
	private Handler handler=new Handler(){
		
		public void handleMessage(Message msg){
			switch(msg.what){
			case SHOW_RESPONSE:
				String response=(String)msg.obj;
				responseText.setText(response);
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendRequest=(Button)findViewById(R.id.send_request);
		responseText=(TextView)findViewById(R.id.response);
		sendRequest.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		if(v.getId()==R.id.send_request){
			sendRequestWithHttpURLConnection();
		}
	}

	private void sendRequestWithHttpURLConnection() {
		// TODO 自动生成的方法存根
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				HttpURLConnection connection =null;
				try{
					//URL url=new URL("http://10.0.2.2/get_data.xml");
					URL url=new URL("http://10.0.2.2/get_data.json");
					connection =(HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in=connection.getInputStream();
					BufferedReader reader=new BufferedReader(new InputStreamReader(in));
					StringBuilder response=new StringBuilder();
					String line;
					while((line=reader.readLine())!=null){
						response.append(line);
					}
					/*Message message=new Message();
					message.what=SHOW_RESPONSE;
					message.obj=response.toString();
					handler.sendMessage(message);*/
					
					//parseXMLWithPull(response.toString());
					//parseXMLWithSAX(response.toString());
					parseJSONWithJSONObject(response.toString());
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					connection.disconnect();
				}
			}
			
		}).start();
	}
	
	private void parseXMLWithPull(String xmlData) {
		// TODO 自动生成的方法存根
		try{
			XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
			XmlPullParser xmlPullParser=factory.newPullParser();
			xmlPullParser.setInput(new StringReader(xmlData));
			int eventType=xmlPullParser.getEventType();
			String id="";
			String name="";
			String version="";
			while(eventType!=XmlPullParser.END_DOCUMENT){
				String nodeName=xmlPullParser.getName();
				switch(eventType){
				case XmlPullParser.START_TAG:{
					if("id".equals(nodeName)){
						id=xmlPullParser.nextText();
					}
					else if("name".equals(nodeName)){
						name=xmlPullParser.nextText();
					}
					else if("version".equals(nodeName)){
						version=xmlPullParser.nextText();
					}
					break;
				}
				case XmlPullParser.END_TAG:{
					if("app".equals(nodeName)){
						Log.d("MainActivity","id is "+id);
						Log.d("MainActivity","name is "+name);
						Log.d("MainActivity","version is "+version);
					}
					break;
				}
				default:
					break;
				}
				eventType=xmlPullParser.next();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void parseXMLWithSAX(String xmlData) {
		// TODO 自动生成的方法存根
		try{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			XMLReader xmlReader=factory.newSAXParser().getXMLReader();
			ContentHandler handler=new ContentHandler();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new StringReader(xmlData)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void parseJSONWithJSONObject(String jsonData) {
		// TODO 自动生成的方法存根
		try{
			JSONArray jsonArray=new JSONArray(jsonData);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				String id=jsonObject.getString("id");
				String name=jsonObject.getString("name");
				String version=jsonObject.getString("version");
				Log.d("MainActivity","id is "+id);
				Log.d("MainActivity","name is "+name);
				Log.d("MainActivity","version is "+version);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
