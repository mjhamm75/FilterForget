package com.app.filterforget;

import java.util.ArrayList;
import java.util.List;

import com.app.filterforget.domain.Filter;

import android.app.Activity;

public class ContainerActivity extends Activity {
	static List<Filter> filters = new ArrayList<Filter>();
	
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
