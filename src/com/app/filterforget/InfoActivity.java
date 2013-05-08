package com.app.filterforget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends ContainerActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
	}

	public void startAlert(View view) {
//		Intent intent = new Intent();
//		intent.setAction("com.app.filterforget.NOTIFY");
//		sendBroadcast(intent);
				
		Intent intent = new Intent(this, OrderAlarmBroadcastReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (8 * 1000),
				pendingIntent);
	}
	
	public void stopAlert(View view) {
		Intent intent = new Intent(this, OrderAlarmBroadcastReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.cancel(pendingIntent);
	}
}
