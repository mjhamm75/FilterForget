package com.app.filterforget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends ContainerActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		Button addCreditCard = (Button)findViewById(R.id.button_add_card);
		addCreditCard.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {			
				Dialog dialog = new Dialog(InfoActivity.this);
			}
		});
	}
}
