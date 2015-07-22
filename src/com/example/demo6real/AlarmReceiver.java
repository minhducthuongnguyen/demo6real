package com.example.demo6real;



import java.util.Random;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
	Random random;
	int r;

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.e("AlarmReceiver", "onreceive intent=null " + (intent==null));
		random=new Random();
		r=random.nextInt(4);
		if (r==0){
			Intent intent1=new Intent(context, Actwake1.class);
			intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent1);}
		else if(r==1){
			Intent intent1=new Intent(context, Actwake2.class);
			intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent1);}
		else if(r==2){
			Intent intent1=new Intent(context, Actwake3.class);
			intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent1);}
			
		else if(r==3){
			Intent intent1=new Intent(context, Actwake4.class);
			intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent1);}
		}
	}


