package com.app.filterforget;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TabHost;

import com.app.filterforget.domain.DbData;
import com.app.filterforget.domain.User;

public class FilterForgetActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Reusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, FilterActivity.class);
		spec = tabHost.newTabSpec("activity_filter").setIndicator("Filter").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, InfoActivity.class);
		spec = tabHost.newTabSpec("activity_info").setIndicator("Info").setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);
		
		DbData dbData = new DbData(this);
		Cursor cursor = dbData.getUser();
		cursor.moveToFirst();
		User.populateUserFromDb(cursor);
		dbData.closeDb();
	}

}
