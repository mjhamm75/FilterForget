package com.app.filterforget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.app.filterforget.domain.Filter;

public class FilterOrderAdapter extends CursorAdapter {

	public FilterOrderAdapter(Context context,Cursor cursor) {
		super(context, cursor, true);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		final Filter filter = Filter.cursorToFilter(cursor);
		
		TextView filterName = (TextView) view.findViewById(R.id.orderFilterName);
		filterName.setText(filter.getName());

//		TextView filterPrice= (TextView) view.findViewById(R.id.filterName);
//		filterPrice.setText(filter.getPrice());
		
		System.out.println("Hello");
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return vi.inflate(R.layout.row_filter_order, null);
	}

}
