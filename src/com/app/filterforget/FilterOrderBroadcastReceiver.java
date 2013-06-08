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
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(dayOfMonth));
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
		// After after 5 seconds
		am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000 * 5, pi);
	}

	public void setAlarmByWeek(Context context, String week, String day) {
		AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(context, FilterOrderBroadcastReceiver.class);
		Calendar calendarWake = Calendar.getInstance();
		calendarWake.set(Calendar.WEEK_OF_MONTH, Integer.valueOf(week));
		Calendar calendarSleep = Calendar.getInstance();
		
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
		// After after 5 seconds
		am.setRepeating(AlarmManager.RTC_WAKEUP, calendarWake.getTimeInMillis(), 1000 * 5, pi);
	}
}
