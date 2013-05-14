package com.app.filterforget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
				final Dialog dialog = new Dialog(InfoActivity.this);
				dialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				dialog.setContentView(R.layout.dialog_add_credit_card);
				dialog.setTitle(R.string.card_info);
				
				Button addCard = (Button)dialog.findViewById(R.id.buttonAddCard);
				Button addCardCancel = (Button)dialog.findViewById(R.id.buttonAddCardCancel);
				addCardCancel.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				dialog.show();
			}
		});
	}
}
