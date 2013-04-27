package com.app.filterforget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filter {
	String name;
	String length;
	String width;
	String height;
	String price;
	String quantity;
	Date lastReplaced;
	boolean checked = false;

	public Filter(String name, String length, String width, String height) {
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public Filter(String name, String length, String width, String height, Date lastReplaced) {
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
		this.lastReplaced = lastReplaced;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Date getLastReplaced() {
		return lastReplaced;
	}

	public void toggleChecked() {
		checked = !checked;
	}

	public boolean getChecked() {
		return checked;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public static List<Filter> getAllSelected(List<Filter> filters) {
		List<Filter> selected = new ArrayList<Filter>();
		for (Filter filter : filters) {
			if (filter.getChecked()) {
				selected.add(filter);
			}
		}
		return selected;
	}

	public String getFormattedDate() {
		if (getLastReplaced() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(getLastReplaced());
		}
		return "Never Replaced";
	}

	public void setLastReplaced(Date lastReplaced) {
		this.lastReplaced = lastReplaced;
	}

	public String getFilterSize() {
		return getWidth() + "x" + getLength() + "x" + getHeight();
	}
}
