package com.example.demo6real;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Act3 extends Activity {
	AlarmManager alarmManager;
    PendingIntent pendingIntent;
    Vibrator v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_act3);
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);		
		Button summary=(Button)findViewById(R.id.button1time);
		alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
		Intent act1intent=getIntent();
		int theHour=act1intent.getIntExtra("hour", 0);
		int theMin=act1intent.getIntExtra("min", 0);
		int theSec=act1intent.getIntExtra("second",0);
		String theHourS;
		if (theHour<=9)	
			theHourS="0"+theHour;
		else
			theHourS=""+theHour;
		
		String theMinS;
		if(theMin<=9)
			theMinS="0"+theMin;
		else
			theMinS=""+theMin;
		
		summary.setText(theHourS+":"+theMinS+"\n");
		
		Calendar curcal=Calendar.getInstance();
		
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, theHour);
        calendar.set(Calendar.MINUTE, theMin);
        calendar.set(Calendar.SECOND, theSec);
        
        if (calendar.after(curcal)){
        // do nothing
	        
	       
	}
        else{
        	int day = curcal.get(Calendar.DAY_OF_YEAR) + 1;
        	calendar.set(Calendar.DAY_OF_YEAR, day);
        }
        
        Intent act2intent=new Intent(this,AlarmReceiver.class);


        pendingIntent = PendingIntent.getBroadcast(this, 0, act2intent, 0);
        alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
        }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act3, menu);
		return true;
	}
	
	@Override
	public void onBackPressed() {
		alarmManager.cancel(pendingIntent);
		Intent intent=new Intent(this, Act2.class);
		startActivityForResult(intent,0);
		
	};

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void Back(View ClickedButton){
		v.vibrate(100);
		alarmManager.cancel(pendingIntent);
		Intent intent=new Intent(ClickedButton.getContext(), Act2.class);
		startActivityForResult(intent,0);
	}
}
