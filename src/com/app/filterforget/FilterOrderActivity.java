package com.app.filterforget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class FilterOrderActivity extends ContainerActivity {
	Context context = this;
	FilterOrderAdapter orderAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		
		orderAdapter = new FilterOrderAdapter(context, dbData.getFilters());
		ListView filterList = (ListView) findViewById(R.id.list_view_order_filter);
		filterList.setDivider(null);
		View footer = getLayoutInflater().inflate(R.layout.activity_order_footer, null);
		filterList.addFooterView(footer);
		filterList.setAdapter(orderAdapter);

		Button order = (Button) findViewById(R.id.orderFilters);
		order.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				new LongRunningIO().execute();
			}
		});

		Button cancel = (Button) findViewById(R.id.orderFiltersCancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
