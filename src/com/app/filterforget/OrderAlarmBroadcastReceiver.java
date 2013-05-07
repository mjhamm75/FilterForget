package com.app.filterforget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OrderAlarmBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent i = new Intent();
		i.setClassName("com.app.filterforget", "com.app.filterforget.FilterOrderPopup");
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}
}
