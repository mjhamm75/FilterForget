package com.app.filterforget;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FilterOrderBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		intent.setClassName("com.app.filterforget", "com.app.filterforget.FilterOrderPopup");
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	public void setAlarmByDay(Context context, String dayOfMonth) {
		AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, FilterOrderBroadcastReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
		Calendar calendar = Calendar.getInstance();
		int today = calendar.get(Calendar.DAY_OF_MONTH);
		if (today >= Integer.valueOf(dayOfMonth)) {
			calendar.add(Calendar.MONTH, 1);
		}
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dayOfMonth));
		am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
	}

	public void setAlarmByWeek(Context context, String week, int day) {		
		AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, FilterOrderBroadcastReceiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.WEEK_OF_MONTH, 1);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		if(Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis() < 0 ) {
			calendar.add(Calendar.MONTH, 1);
		}
		am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() - calendar.getTimeInMillis(), pi);
	}
}
