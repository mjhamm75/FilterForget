package com.app.filterforget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.app.filterforget.domain.DbData;
import com.app.filterforget.domain.Filter;

public class ContainerActivity extends Activity {
	static List<Filter> filters = new ArrayList<Filter>();
	DbData dbData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dbData = new DbData(this);
	}

	protected static List<Filter> getSelectedFilters() {
		List<Filter> selectedFilters = new ArrayList<Filter>();
		for(Filter filter: filters) {
			if(filter.getChecked() == true) {
				selectedFilters.add(filter);
			}
		}
		return selectedFilters;
	}
	
	protected static double getTotal() {
		double total = 0;
		for(Filter filter: filters) {
			
		}
		return total;		
	}
}
