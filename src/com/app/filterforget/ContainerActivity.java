package com.app.filterforget;

import android.app.Activity;
import android.os.Bundle;

import com.app.filterforget.domain.DbData;

public class ContainerActivity extends Activity {
	DbData dbData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dbData = new DbData(this);
	}
}
