package com.example.fragmentbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NewsTitleFragment extends Fragment implements OnItemClickListener {
	
	private ListView newsTitleListView;
	
	private List<News> newsList;
	
	private NewsAdapter adapter;
	
	private boolean isTwoPane;
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		newsList=getNews();
		adapter =new NewsAdapter(activity,R.layout.news_item, newsList);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.news_title_frag, container,false);
		newsTitleListView=(ListView)view.findViewById(R.id.new_title_list_view);
		newsTitleListView.setAdapter(adapter);
		newsTitleListView.setOnItemClickListener(this);
		return view;
	}
	
	public void onActivityCreate(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		if(getActivity().findViewById(R.id.news_content_layout)!=null){
			isTwoPane=true;
		}
		else{
			isTwoPane=false;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO 自动生成的方法存根
		News news=newsList.get(position);
		if(isTwoPane){
			NewsContentFragment newsContentFragment=(NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
			newsContentFragment.refresh(news.getTitle(), news.getContent());
		}
		else{
			NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
		}
		
	}
	
	
	private List<News> getNews() {
		// TODO 自动生成的方法存根
		
		List<News> newsList=new ArrayList<News>();
		News news1=new News();
		news1.setTitle("Succeed in College");
		news1.setContent("College freshmen will soon learn to live with a roommate.");
		newsList.add(news1);
		
		News news2=new News();
		news2.setTitle("Succeed in College 111111111111");
		news2.setContent("College freshmen will soon learn to live with a roommate.1111111111111");
		newsList.add(news2);
		return newsList;
		
	}

}
