package com.app.filterforget;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InfoActivity extends Activity {
	// private OrderAlarmBroadcastReceiver alarm;
	// private Context context = this;
	//
	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.activity_info);
	//
	// alarm = new OrderAlarmBroadcastReceiver();
	//
	// TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
	// timePicker.setOnTimeChangedListener(new
	// TimePicker.OnTimeChangedListener() {
	// @Override
	// public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
	// System.out.println(hourOfDay);
	// System.out.println(minute);
	// }
	// });
	//
	// Button alarmButton = (Button) findViewById(R.id.alarm);
	// alarmButton.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// alarm.setAlarm(context);
	// }
	// });
	// }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
	}

	public void startAlert(View view) {
		Intent intent = new Intent(this, OrderAlarmBroadcastReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5 * 1000), pendingIntent);
		Toast.makeText(this, "Alarm set in " + 5 + " seconds", Toast.LENGTH_LONG).show();
	}
}
