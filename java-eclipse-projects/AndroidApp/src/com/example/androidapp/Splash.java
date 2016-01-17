package com.example.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	
	private MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		//Creating a new sound clip
		ourSong = MediaPlayer.create(Splash.this, R.raw.rippling_water);
		ourSong.start();	//Starting the media clip
		
		Thread timer = new Thread() {
			//Implementing the run() method
			public void run() {
				//try-catch-finally block
				try {
					//makes the current thread to sleep for 5 seconds
					sleep(5000);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					//Creating new Intent object
					Intent openStartingPoint = new Intent("com.example.androidapp.MENU");
					
					//Starting a new activity
					startActivity(openStartingPoint);
				}
			}
		};
		
		//Starting thread
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();//Stopping the sound clip so at the 
						//end of this activity, the sound also stops
		finish();	//Killing the activity
		
	}
	
	
}
