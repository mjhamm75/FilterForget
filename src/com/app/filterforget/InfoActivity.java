package com.app.filterforget;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.app.filterforget.domain.CreditCard;

public class InfoActivity extends ContainerActivity {
	List<CreditCard> cards;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		cards = new ArrayList<CreditCard>();

		Button addCreditCard = (Button) findViewById(R.id.button_add_card);
		addCreditCard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(InfoActivity.this);
				final Calendar dateTime = Calendar.getInstance();
				dialog.setContentView(R.layout.dialog_add_credit_card);
				dialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				dialog.setTitle(R.string.card_info);

				final EditText expDate = (EditText) dialog.findViewById(R.id.expDate);

				ImageButton expDateButton = (ImageButton) dialog.findViewById(R.id.buttonExpDate);
				expDateButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {

						new DatePickerDialog(v.getContext(), d, dateTime.get(Calendar.YEAR), dateTime
								.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH)).show();
					}

					DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
						@Override
						public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
							dateTime.set(Calendar.YEAR, year);
							dateTime.set(Calendar.MONTH, monthOfYear);
							dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
							expDate.setText(monthOfYear + "/" + dayOfMonth + "/" + year);
						}
					};
				});

				Button addCard = (Button) dialog.findViewById(R.id.buttonAddCard);
				addCard.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						EditText cardNumber = (EditText) dialog.findViewById(R.id.creditCardNumber);
						String number = cardNumber.getText().toString();
						EditText expDate = (EditText)dialog.findViewById(R.id.expDate);
						String expirationDateString = expDate.getText().toString();
						
						cards.add(new CreditCard(number, expirationDateString));

					}
				});

				Button addCardCancel = (Button) dialog.findViewById(R.id.buttonAddCardCancel);
				addCardCancel.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				dialog.show();
			}
		});
		
		ListView cards = (ListView)findViewById(R.id.list_cards);
		
	}
}
