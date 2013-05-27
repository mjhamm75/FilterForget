package com.app.filterforget;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.filterforget.domain.Filter;

public class FilterSelectAdapter extends CursorAdapter {

	public FilterSelectAdapter(Context context, Cursor cursor) {
		super(context, cursor, true);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		CheckBox box = (CheckBox) view.findViewById(R.id.selectFilterCheck);
		final Filter filter = Filter.cursorToFilter(cursor);
		box.setChecked(filter.getChecked());
		box.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				filter.toggleChecked();
			}
		});

		TextView filterName = (TextView) view.findViewById(R.id.selectFilterName);
		filterName.setText(filter.getName());

		Spinner filterPrice = (Spinner) view.findViewById(R.id.selectFilterPrice);
		filterPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String price = parent.getItemAtPosition(position).toString();
				filter.setPrice(price);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				Log.i("OrderAdapter", "Filter price has to be selected.");
			}
		});

	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return vi.inflate(R.layout.row_filter_select, null);
	}
}
