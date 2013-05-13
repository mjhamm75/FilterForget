package com.app.filterforget;

import java.util.List;

import com.app.filterforget.domain.Filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FilterOrderAdapter extends ArrayAdapter<Filter> {
	List<Filter> filters;

	public FilterOrderAdapter(Context context, int textViewResourceId, List<Filter> filters) {
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
		Filter o = filters.get(position);
		if (o != null) {
			TextView filterName = (TextView) v.findViewById(R.id.orderFilterName);
			filterName.setText(o.getName());

			TextView filterPrice= (TextView) v.findViewById(R.id.orderFilterName);
			filterPrice.setText(o.getName());
		}
		return v;
	}

}
