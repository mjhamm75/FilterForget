package com.app.filterforget;

import com.app.filterforget.domain.DbData;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class FilterOrderAdapter extends CursorAdapter {
	Cursor cursor;

	public FilterOrderAdapter(Context context,Cursor cursor) {
		super(context, cursor, true);
		this.cursor = cursor;
	}

	@Override
	public void bindView(View v, Context context, Cursor cursor) {
		TextView filterName = (TextView) v.findViewById(R.id.orderFilterName);
		filterName.setText(cursor.getString(cursor.getColumnIndex(DbData.FILTER_NAME)));

		TextView filterPrice= (TextView) v.findViewById(R.id.filterName);
		filterPrice.setText(cursor.getString(cursor.getColumnIndex(DbData.FILTER_PRICE)));
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return vi.inflate(R.layout.row_filter_order, null);
	}

}
