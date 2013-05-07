package com.app.filterforget;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class FilterSelectActivity extends Activity {
	final Context context = this;
	static List<Filter> filters;
	SelectAdapter selectAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		filters = FilterActivity.getFilters();
		selectAdapter = new SelectAdapter(context, R.layout.row_filter_select, filters);

		final ListView lv = (ListView) findViewById(R.id.list_view_select_filter);
		lv.setAdapter(selectAdapter);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

			}
		});

		Button selectButton = (Button) findViewById(R.id.selectFilters);
		selectButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Filter> selected = Filter.getAllSelected(filters);

			}
		});

		Button orderButtonCancel = (Button) findViewById(R.id.orderFiltersCancel);
		orderButtonCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FilterSelectActivity.this.finish();
			}
		});
	}
}