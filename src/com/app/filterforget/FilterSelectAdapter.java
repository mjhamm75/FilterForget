package com.app.filterforget;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class FilterSelectAdapter extends ArrayAdapter<Filter> {
	List<Filter> filters;

	public FilterSelectAdapter(Context context, int textViewResourceId, List<Filter> filters) {
		super(context, textViewResourceId, filters);
		this.filters = filters;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.row_filter_select, null);
		}
		Filter filter = filters.get(position);
		if (filter != null) {
			final Filter finalFilter = filter;

			CheckBox box = (CheckBox) v.findViewById(R.id.selectFilterCheck);
			box.setChecked(filter.getChecked());
			box.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					finalFilter.toggleChecked();
				}
			});

			TextView filterName = (TextView) v.findViewById(R.id.selectFilterName);
			filterName.setText(filter.getName());

			Spinner filterPrice = (Spinner) v.findViewById(R.id.selectFilterPrice);
			filterPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					String price = parent.getItemAtPosition(position).toString();
					finalFilter.setPrice(price);
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					Log.i("OrderAdapter", "Filter price has to be selected.");
				}
			});

		}
		return v;
	}
}
