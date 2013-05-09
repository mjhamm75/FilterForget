package com.app.filterforget;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class FilterOrderActivity extends ContainerActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);

		ListView filterList = (ListView) findViewById(R.id.list_view_order_filter);

		Button order = (Button) findViewById(R.id.orderFilters);
		order.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("ORDER");
			}
		});

		Button cancel = (Button) findViewById(R.id.orderFiltersCancel);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("CANCEL");
			}
		});
	}
}
