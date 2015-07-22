package com.example.demo6real;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Act1 extends Activity {

	Vibrator v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act1);
		v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act1, menu);
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
	
	public void Add(View ClickedButton){
		v.vibrate(100);
		Intent intent=new Intent(ClickedButton.getContext(), Act2.class);
		startActivityForResult(intent,0);
}
	public void Secret(View ClickedButton){
		v.vibrate(100);
		Intent intent=new Intent(ClickedButton.getContext(), Secret.class);
		startActivityForResult(intent,0);
}

}
