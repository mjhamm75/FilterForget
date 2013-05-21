package com.app.filterforget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.app.filterforget.domain.DbData;

public class CreditCardAdapter extends CursorAdapter {
	Context context;
	Cursor cursor;

	public CreditCardAdapter(Context context, Cursor cursor) {
		super(context, cursor, true);
		this.context = context;
		this.cursor = cursor;
	}

	@Override
	public void bindView(View v, Context context, Cursor cursor) {
		TextView cardNumber = (TextView) v.findViewById(R.id.cardNumber);
		cardNumber.setText(cursor.getString(cursor.getColumnIndex(DbData.CARD_NUMBER)));

		TextView expDate = (TextView) v.findViewById(R.id.cardExpDate);
		expDate.setText(cursor.getString(cursor.getColumnIndex(DbData.CARD_EXP_DATE)));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return vi.inflate(R.layout.row_credit_card, null);
	}
}
