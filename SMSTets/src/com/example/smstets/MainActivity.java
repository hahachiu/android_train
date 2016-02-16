package com.example.smstets;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.*;
import android.os.Bundle;
import android.telephony.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {

	private TextView sender;
	
	private TextView content;
	
	private IntentFilter receiveFilter;
	
	private MessageReceiver messageReceiver;
	
	private EditText to;
	
	private EditText msgInput;
	
	private Button send;
	
	private IntentFilter sendFilter;
	
	private SendStatusReceiver sendStatusReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sender=(TextView)findViewById(R.id.sender);
		content=(TextView)findViewById(R.id.content);
		
		receiveFilter=new IntentFilter();
		receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
		receiveFilter.setPriority(1000);
		messageReceiver=new MessageReceiver();
		registerReceiver(messageReceiver,receiveFilter);
		
		sendFilter=new IntentFilter();
		sendFilter.addAction("SENT_SMS_ACTION");
		sendStatusReceiver=new SendStatusReceiver();
		registerReceiver(sendStatusReceiver,sendFilter);
		
		to=(EditText)findViewById(R.id.to);
		msgInput=(EditText)findViewById(R.id.msg_input);
		send=(Button)findViewById(R.id.send);
		send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
				Intent sendIntent=new Intent("SENT_SMS_ACTION");
				PendingIntent pi=PendingIntent.getBroadcast(MainActivity.this, 0, sendIntent, 0);
				SmsManager smsmanager=SmsManager.getDefault();
				smsmanager.sendTextMessage(to.getText().toString(),null,msgInput.getText().toString(),pi,null);
			}
			
		});
	}
	
	
	protected void onDestroy(){
		super.onDestroy();
		unregisterReceiver(messageReceiver);
		unregisterReceiver(sendStatusReceiver);
	}
	
	
	class MessageReceiver extends BroadcastReceiver{

		
		@SuppressWarnings("deprecation")
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO 自动生成的方法存根
			
			abortBroadcast();
			Bundle bundle=intent.getExtras();
			Object[] pdus=(Object[])bundle.get("pdus");
			SmsMessage[] messages=new SmsMessage[pdus.length];
			for(int i=0;i<messages.length;i++){
				messages[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
			}
			String address=messages[0].getOriginatingAddress();
			String fullMessage="";
			for(SmsMessage message:messages){
				fullMessage+=message.getMessageBody();
			}
			sender.setText(address);
			content.setText(fullMessage);
			
		}
		
		
	}
	
	
class SendStatusReceiver extends BroadcastReceiver{

		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO 自动生成的方法存根
			
			if(getResultCode()==RESULT_OK){
				Toast.makeText(context, "Send succeeded", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(context, "Send failed", Toast.LENGTH_SHORT).show();
			}
			
		}
		
		
	}
	
	
}
