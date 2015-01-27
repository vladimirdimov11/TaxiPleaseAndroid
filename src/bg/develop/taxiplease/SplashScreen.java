package bg.develop.taxiplease;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;

public class SplashScreen extends Activity {

	int timeout = 2500; // Choose the delay (1000 = 1 second)

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		TranslateAnimation animation = new TranslateAnimation(0.0f, 600.0f,
	            0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
	    animation.setDuration(2500);  // animation duration 
//	    animation.setRepeatCount(5); // animation repeat count
//	    animation.setRepeatMode(2);
		
		ImageView small_taxi = (ImageView) findViewById(R.id.ivSmallTaxi);
		small_taxi.startAnimation(animation);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				//Redirecting to the home page
				Intent redirect = new Intent(getApplicationContext(), LogInActivity.class);
				startActivity(redirect);
				finish();
			}
		}, timeout);
	}
}
