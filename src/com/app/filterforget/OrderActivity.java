package com.app.filterforget;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class OrderActivity extends Activity {
	final Context context = this;
	static List<Filter> filters;
	OrderAdapter orderAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		filters = FilterActivity.getFilters();
		orderAdapter = new OrderAdapter(context, R.layout.row_filter_order, filters);

		final ListView lv = (ListView) findViewById(R.id.list_view_order_filter);
		lv.setAdapter(orderAdapter);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
			}
		});
		
		
		
		Button orderButton = (Button) findViewById(R.id.orderFilters);
		orderButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Filter> selected = Filter.getAllSelected(filters);
				System.out.println(selected.size());
				for(Filter filter: selected){
					System.out.println(filter.name);
				}
			}
		});

		Button orderButtonCancel = (Button) findViewById(R.id.orderFiltersCancel);
		orderButtonCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				OrderActivity.this.finish();
			}
		});
	}
}