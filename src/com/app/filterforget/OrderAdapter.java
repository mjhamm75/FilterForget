package com.app.filterforget;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class OrderAdapter extends ArrayAdapter<Filter> {
	private List<Filter> filters;

	public OrderAdapter(Context context, int textViewResourceId, List<Filter> filters) {
		super(context, textViewResourceId, filters);
		this.filters = filters;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.row_filter_order, null);
		}
		Filter filter = filters.get(position);
		if (filter != null) {
			final Filter finalFilter = filter;
			CheckBox box = (CheckBox) v.findViewById(R.id.orderFilterCheck);
			box.setChecked(filter.getChecked());
			box.setOnClickListener(new OnClickListener() {				
				@Override
				public void onClick(View v) {
					finalFilter.toggleChecked();
				}
			});			
			
			TextView filterName = (TextView) v.findViewById(R.id.orderFilterName);
			filterName.setText(filter.getName());
		}
		return v;
	}

}
