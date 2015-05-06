package com.dat.soslima;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {

	private static final int SPLASH_SCREEN_DELAY = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);
		
		TimerTask task = new TimerTask(){

			@Override
			public void run() {
				//Intent mainIntent = new Intent().setClass(Splash.this,MainActivity.class);
				Intent mainIntent = new Intent(Splash.this,MainActivity.class);
				startActivity(mainIntent);
				finish();
			}
		};
		
		Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
	}
}
