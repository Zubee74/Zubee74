package com.profile.spc;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpsActivity extends Activity {
	
	 private Button Vibrate , Ring , Silent , Mode;
	 private TextView Status,sms;
	 public static AudioManager myAudioManager;
	 MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sps);
		Status = (TextView)findViewById(R.id.textView2);
	    myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
	    
	}
	
	public void mode(View view){
	     int mod = myAudioManager.getRingerMode();
	     if(mod == AudioManager.RINGER_MODE_NORMAL){
	         Status.setText("Current Status: Ring");
	         mp=MediaPlayer.create(getApplicationContext(),R.raw.spcringtone);
	         mp.start();
	   }
	   else if(mod == AudioManager.RINGER_MODE_SILENT){
	       Status.setText("Current Status: Silent");
	   }
	   else if(mod == AudioManager.RINGER_MODE_VIBRATE){
	      Status.setText("Current Status: Vibrate");
	   }
	   else{

	   }
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sps, menu);
		return true;
	}

}
