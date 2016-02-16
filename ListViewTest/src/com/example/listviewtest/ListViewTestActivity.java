package com.example.listviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewTestActivity extends Activity {
	/*private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry"
			,"Cherry","Mango"};*/
	
	private List<Fruit> fruitList=new ArrayList<Fruit>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		/*ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListViewTestActivity.this,android.R.layout.simple_list_item_1,data);*/
		
		
		
		initFruits();
		FruitAdapter adapter=new FruitAdapter(ListViewTestActivity.this,R.layout.fruit_item,fruitList);
		
		
		ListView listview=(ListView)findViewById(R.id.list_view);
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO 自动生成的方法存根
				Fruit fruit=fruitList.get(position);
				Toast.makeText(ListViewTestActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	
	
	private void initFruits(){
		Fruit apple=new Fruit("Apple",R.drawable.ic_launcher);
		fruitList.add(apple);
		Fruit banana=new Fruit("Banana",R.drawable.ic_launcher);
		fruitList.add(banana);
		Fruit orange=new Fruit("Orangee",R.drawable.ic_launcher);
		fruitList.add(orange);
		Fruit watermelon=new Fruit("Watermelon",R.drawable.ic_launcher);
		fruitList.add(watermelon);
		Fruit pear=new Fruit("Pear",R.drawable.ic_launcher);
		fruitList.add(pear);
		Fruit grape=new Fruit("Grape",R.drawable.ic_launcher);
		fruitList.add(grape);
		Fruit pineapple=new Fruit("Pineapple",R.drawable.ic_launcher);
		fruitList.add(pineapple);
		Fruit strawberry=new Fruit("Strawberry",R.drawable.ic_launcher);
		fruitList.add(strawberry);
		Fruit cherry=new Fruit("Cherry",R.drawable.ic_launcher);
		fruitList.add(cherry);
		Fruit mango=new Fruit("Mango",R.drawable.ic_launcher);
		fruitList.add(mango);
	}
}
