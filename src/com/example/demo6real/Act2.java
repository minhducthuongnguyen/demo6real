package com.example.demo6real;

import java.util.Calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class Act2 extends Activity {

	SeekBar SeekBar1;
	TextView h;
	int theH;
	
	SeekBar SeekBar2;
	TextView m;
	int theM;
	
	Vibrator v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_act2);
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);		
		
		//hour set
		SeekBar1 = (SeekBar)findViewById(R.id.seekBar1); 
	    h = (TextView)findViewById(R.id.textView1); 

	    SeekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

	   @Override 
	   public void onProgressChanged(SeekBar SeekBar1, int progress1, 
	     boolean fromUser) { 
	    // TODO Auto-generated method stub 
		   if(progress1<=9)
			   h.setText("0"+String.valueOf(progress1)); 
		   else
			   h.setText(String.valueOf(progress1)); 
	    theH=progress1;
	   } 

	   @Override 
	   public void onStartTrackingTouch(SeekBar seekBar) { 
	    // TODO Auto-generated method stub 
	   } 

	   @Override 
	   public void onStopTrackingTouch(SeekBar seekBar) { 
	    // TODO Auto-generated method stub 
	   } 
	       }); 
	    
	    //min set
	    
	    SeekBar2 = (SeekBar)findViewById(R.id.seekBar2); 
	    m = (TextView)findViewById(R.id.textView5); 

	    SeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

	   @Override 
	   public void onProgressChanged(SeekBar SeekBar2, int progress2, 
	     boolean fromUser) { 
	    // TODO Auto-generated method stub 
		   if(progress2<=9)
			   m.setText("0"+String.valueOf(progress2)); 
		   else
			   m.setText(String.valueOf(progress2)); 
	    theM=progress2;
	   } 

	   @Override 
	   public void onStartTrackingTouch(SeekBar seekBar) { 
	    // TODO Auto-generated method stub 
	   } 

	   @Override 
	   public void onStopTrackingTouch(SeekBar seekBar) { 
	    // TODO Auto-generated method stub 
	   } 
	       }); 
	   } 
		
		
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act2, menu);
		return true;
	}

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
		Intent intent=new Intent(ClickedButton.getContext(), Act1.class);
		startActivityForResult(intent,0);
	}
	
	public void Forward(View ClickedButton){
		v.vibrate(100);
		Calendar calendar = Calendar.getInstance();
		
        calendar.set(Calendar.HOUR_OF_DAY, theH);
        calendar.set(Calendar.MINUTE, theM);
        calendar.set(Calendar.SECOND,0);
        Intent intent=new Intent(ClickedButton.getContext(), Act3.class);
		
		
		intent.putExtra("hour",theH);
		intent.putExtra("min",theM);
		intent.putExtra("second", 0);
		startActivityForResult(intent,0);
	}
}
