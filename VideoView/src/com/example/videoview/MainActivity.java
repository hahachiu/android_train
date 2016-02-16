package com.example.videoview;

import java.io.File;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity implements OnClickListener{

	
	private Button play;
	
	private Button pause;
	
	private Button replay;
	
	private VideoView videoView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		play=(Button)findViewById(R.id.play);
		pause=(Button)findViewById(R.id.pause);
		replay=(Button)findViewById(R.id.replay);
		videoView=(VideoView)findViewById(R.id.videoView1);
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		replay.setOnClickListener(this);
		initVideoPath();
	}

	private void initVideoPath() {
		// TODO 自动生成的方法存根
		File file=new File(Environment.getExternalStorageDirectory(),"movie.3gp");
		videoView.setVideoPath(file.getPath());
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch(v.getId()){
		case R.id.play:
			if(!videoView.isPlaying()){
				videoView.start();
				Toast.makeText(getBaseContext(), "!!", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.pause:
			if(videoView.isPlaying()){
				videoView.pause();
			}
			break;
		case R.id.replay:
			if(videoView.isPlaying()){
				videoView.resume();
			}
			break;
		default:
			break;
		}
	}
	
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		if(videoView!=null){
			videoView.suspend();
		}
	}
}
