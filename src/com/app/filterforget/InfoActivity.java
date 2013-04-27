package com.app.filterforget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TimePicker;

public class InfoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				System.out.println(hourOfDay);
				System.out.println(minute);				
			}
		});
	}
}
