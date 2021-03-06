package com.app.filterforget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.app.filterforget.domain.Filter;

public class FilterActivity extends ContainerActivity {
	final Context context = this;
	private FilterAdapter filterAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);

		ListView filterList = (ListView)findViewById(R.id.filter_list);

		filterList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				final long _id = id;
				final Dialog dialog = new Dialog(FilterActivity.this);
				dialog.setContentView(R.layout.filter_single);
				dialog.setTitle(R.string.delete_filter);

				Button singleDelete = (Button) dialog.findViewById(R.id.buttonFilterSingleDelete);
				singleDelete.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						
						dbData.deleteFilter(_id);
						Cursor cursor = dbData.getFilters();
						filterAdapter.changeCursor(cursor);
						dialog.dismiss();
					}
				});

				Button cancel = (Button) dialog.findViewById(R.id.buttonFilterSingleCancel);
				cancel.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});

				dialog.show();
			}
		});

		Button addFilter = (Button) findViewById(R.id.addFilter);
		addFilter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final Dialog dialog = new Dialog(FilterActivity.this);
				dialog.setContentView(R.layout.dialog_create_filter);
				dialog.getWindow().setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				dialog.setTitle("Create Filter");
				Button buttonOk = (Button) dialog.findViewById(R.id.buttonFilterOk);
				buttonOk.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						EditText filterName = (EditText) dialog.findViewById(R.id.filterName);
						Spinner filterLength = (Spinner) dialog.findViewById(R.id.spinnerFilterLength);
						Spinner filterHeight = (Spinner) dialog.findViewById(R.id.spinnerFilterHeight);
						Spinner filterWidth = (Spinner) dialog.findViewById(R.id.spinnerFilterWidth);
						String length = filterLength.getSelectedItem().toString();
						String width = filterWidth.getSelectedItem().toString();
						String height = filterHeight.getSelectedItem().toString();
						String name = filterName.getText().toString();
						Filter filter = new Filter(name, length, width, height, "1", "1", "1", false);
						dbData.insertFilter(filter);
						Cursor cursor = dbData.getFilters();
						filterAdapter.changeCursor(cursor);
						dialog.dismiss();
					}
				});
				

				Button buttonCancel = (Button) dialog.findViewById(R.id.buttonFilterCancel);
				buttonCancel.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
					}
				});

				dialog.show();
			}
		});

		Button selectFilters = (Button) findViewById(R.id.selectFilters);
		selectFilters.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent orderIntent = new Intent(FilterActivity.this, FilterSelectActivity.class);
				FilterActivity.this.startActivity(orderIntent);
			}
		});
		filterAdapter = new FilterAdapter(context, dbData.getFilters());
		filterList.setAdapter(filterAdapter);

	}
}
