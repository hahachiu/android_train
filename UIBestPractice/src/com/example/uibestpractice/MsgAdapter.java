package com.example.uibestpractice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;
	
	public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects) {
		super(context, textViewResourceId, objects);
		resourceId=textViewResourceId;
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		Msg msg=getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView==null){
			view=LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder=new ViewHolder();
			viewHolder.leftLayout=(LinearLayout)view.findViewById(R.id.left_layout);
			viewHolder.rightLayout=(LinearLayout)view.findViewById(R.id.right_layout);
			viewHolder.leftmsg=(TextView)view.findViewById(R.id.left_msg);
			viewHolder.rightmsg=(TextView)view.findViewById(R.id.right_msg);
			view.setTag(viewHolder);
		}
		else{
			view=convertView;
			viewHolder=(ViewHolder)view.getTag();
		}
		if(msg.getType()==Msg.TYPE_RECEIVED){
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftmsg.setText(msg.getContent());
		}
		else{
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.rightmsg.setText(msg.getContent());
		}
		return view;
	}
	
	class ViewHolder{
		
		LinearLayout leftLayout;
		
		LinearLayout rightLayout;
		
		TextView leftmsg;
		
		TextView rightmsg;
		
	}
	
	
	
	
	
	
	
}
