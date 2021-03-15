package com.profile.spc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ButtonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);
	}
	//conectivity of buttons or redirections;
	.........................................
	public void SPC(View v){
		Intent intent=new Intent(getApplicationContext(),SpsActivity.class);
		startActivity(intent);
	}
	
	public void GPS(View v){
		Intent intent=new Intent(getApplicationContext(),GpsActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.button, menu);
		return true;
	}

}
