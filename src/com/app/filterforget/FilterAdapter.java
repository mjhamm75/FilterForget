package com.app.filterforget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.app.filterforget.domain.DbData;

public class FilterAdapter extends CursorAdapter {
	Context context;
	Cursor cursor;

	public FilterAdapter(Context context, Cursor cursor) {
		super(context, cursor, true);
		this.context = context;
		this.cursor = cursor;
	}

	@Override
	public void bindView(View v, Context context, Cursor cursor) {
		TextView filterName = (TextView) v.findViewById(R.id.filterName);
		filterName.setText(cursor.getString(cursor.getColumnIndex(DbData.FILTER_NAME)));
		TextView lastReplaced = (TextView) v.findViewById(R.id.lastReplaced);
		lastReplaced.setText(cursor.getString(cursor.getColumnIndex(DbData.FILTER_LAST_REPLACED)));
		TextView filterSize = (TextView) v.findViewById(R.id.filterSize);
		String length = cursor.getString(cursor.getColumnIndex(DbData.FILTER_LENGTH));
		String width = cursor.getString(cursor.getColumnIndex(DbData.FILTER_WIDTH));
		String height = cursor.getString(cursor.getColumnIndex(DbData.FILTER_HEIGHT));
		filterSize.setText(length + "x" + width + "x" + height);

	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		return vi.inflate(R.layout.row_activity_filter, null);
	}
}
