package com.app.filterforget;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.filterforget.domain.CreditCard;

public class CreditCardAdapter extends ArrayAdapter<CreditCard> {
	List<CreditCard> cards;

	public CreditCardAdapter(Context context, int textViewResourceId, List<CreditCard> cards) {
		super(context, textViewResourceId, cards);
		this.cards = cards;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.row_credit_card, null);
		}
		CreditCard card = cards.get(position);
		if (card != null) {
			TextView cardNumber = (TextView) v.findViewById(R.id.cardNumber);
			cardNumber.setText(card.getMaskedNumber());

			TextView expDate = (TextView) v.findViewById(R.id.cardExpDate);
			expDate.setText(card.getExpDate());
		}
		return v;
	}

}
