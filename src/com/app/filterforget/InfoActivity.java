package com.app.filterforget;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.filterforget.domain.CreditCard;
import com.app.filterforget.domain.User;

public class InfoActivity extends ContainerActivity {
	CreditCardAdapter cardAdapter;
	List<CreditCard> cards;
	Context context = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		cards = new ArrayList<CreditCard>();
		
		Button filterOrderActivity = (Button) findViewById(R.id.button_add_order_date);
		filterOrderActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(InfoActivity.this);
				dialog.setContentView(R.layout.dialog_add_order_date);
				dialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				dialog.setTitle(R.string.add_order_date);
				
				Button addOrderDate = (Button) dialog.findViewById(R.id.buttonAddDate);
				addOrderDate.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(InfoActivity.this, "Order Date Changed", Toast.LENGTH_LONG).show();
						dialog.dismiss();
					}
				});

				Button addDateCancel = (Button) dialog.findViewById(R.id.buttonAddDateCancel);
				addDateCancel.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				dialog.show();
				
				dialog.show();
			}
		});
		
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
						EditText expDate = (EditText) dialog.findViewById(R.id.expDate);
						String expirationDate = expDate.getText().toString();

						dbData.insertCreditCard(new CreditCard(number, expirationDate, ""));						
						Cursor cursor = dbData.getCreditCards();
						cardAdapter.changeCursor(cursor);

						dialog.dismiss();

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

		Button editInfo = (Button) findViewById(R.id.button_edit_info);
		editInfo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(InfoActivity.this);
				dialog.setContentView(R.layout.dialog_add_info);
				dialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				dialog.setTitle(R.string.personal_info);

				final EditText firstName = (EditText) dialog.findViewById(R.id.nameFirstAdd);
				firstName.setText(User.USER.getFirstName());
				
				final EditText lastName = (EditText) dialog.findViewById(R.id.nameLastAdd);
				lastName.setText(User.USER.getLastName());
				
				final EditText address = (EditText) dialog.findViewById(R.id.addressAdd);
				address.setText(User.USER.getAddress1());

				final EditText city = (EditText) dialog.findViewById(R.id.cityAdd);
				city.setText(User.USER.getCity());
				
				final EditText state = (EditText) dialog.findViewById(R.id.stateAdd);
				state.setText(User.USER.getState());
				
				final EditText zipcode = (EditText) dialog.findViewById(R.id.zipcodeAdd);
				zipcode.setText(User.USER.getZipcode());
				
				
				Button addEditedInfo = (Button) dialog.findViewById(R.id.buttonAddInfo);
				addEditedInfo.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						String first = firstName.getText().toString();
						String last = lastName.getText().toString();
						String add = address.getText().toString();
						String c = city.getText().toString();
						String s = state.getText().toString();
						String zip = zipcode.getText().toString();
						User.USER.setFirstName(first);
						User.USER.setLastName(last);
						User.USER.setAddress1(add);
						User.USER.setCity(c);
						User.USER.setState(s);
						User.USER.setZipcode(zip);
						dbData.updateUser(User.USER);
						paintInfo();
						dialog.dismiss();
					}
				});

				Button cancelAddInfo = (Button) dialog.findViewById(R.id.buttonAddInfoCancel);
				cancelAddInfo.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});

				dialog.show();
			}
		});

		paintInfo();
		cardAdapter = new CreditCardAdapter(context, dbData.getCreditCards());
		ListView cardList = (ListView) findViewById(R.id.list_cards);
		cardList.setAdapter(cardAdapter);
	}

	private void paintInfo() {
		TextView firstName = (TextView) findViewById(R.id.nameFirst);
		firstName.setText(User.USER.getFirstName());
		TextView lastName = (TextView) findViewById(R.id.nameLast);
		lastName.setText(User.USER.getLastName());
		TextView address = (TextView) findViewById(R.id.address);
		address.setText(User.USER.getAddress1());
		TextView city = (TextView) findViewById(R.id.city);
		city.setText(User.USER.getCity());
		TextView state = (TextView) findViewById(R.id.state);
		state.setText(User.USER.getState());
		TextView zipCode = (TextView) findViewById(R.id.zipcode);
		zipCode.setText(User.USER.getZipcode());
	}
}
