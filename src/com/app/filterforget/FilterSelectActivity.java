package com.app.filterforget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class FilterSelectActivity extends ContainerActivity {
	final Context context = this;
	FilterSelectAdapter selectAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		filters = ContainerActivity.getFilters();
		selectAdapter = new FilterSelectAdapter(context, R.layout.row_filter_select, filters);

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
				Intent orderIntent = new Intent(FilterSelectActivity.this, FilterOrderActivity.class);
				FilterSelectActivity.this.startActivity(orderIntent);
			}
		});

		Button orderButtonCancel = (Button) findViewById(R.id.selectFiltersCancel);
		orderButtonCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FilterSelectActivity.this.finish();
			}
		});
	}
}