package com.app.filterforget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class FilterActivity extends ListActivity {
	final Context context = this;
	static List<Filter> filters = new ArrayList<Filter>();
	private FilterAdapter filterAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);

		ListView filterActivityView = getListView();
		createFilters();

		Button addFilter = (Button) findViewById(R.id.addFilter);
		addFilter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("Add");
			}
		});

		Button orderFilter = (Button) findViewById(R.id.orderFilter);
		orderFilter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("Order");
			}
		});

		filterAdapter = new FilterAdapter(context, R.layout.row_activity_filter, filters);
		setListAdapter(filterAdapter);

	}

	private void createFilters() {
		Date today = new Date();
		filters.add(new Filter("Hall", "1", "1", "1", today));
		filters.add(new Filter("Dining Room", "2", "2", "2", today));
		filters.add(new Filter("Kitchen", "3", "3", "3", today));
		filters.add(new Filter("Foyer", "4", "4", "4", today));
	}

}
