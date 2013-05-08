package com.app.filterforget;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ContainerActivity extends Activity {
	static List<Filter> filters = new ArrayList<Filter>();

	public static List<Filter> getFilters() {
		return filters;
	}
}
