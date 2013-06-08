package com.app.filterforget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class FilterOrderPopup extends Activity {
	static final String ACTION = "android.filterforget.NOTIFY";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		displayAlert();
	}

	private void displayAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Time to order filters").setCancelable(false)
				.setPositiveButton("Order Now", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
						Intent orderIntent = new Intent(FilterOrderPopup.this, FilterSelectActivity.class);
						FilterOrderPopup.this.startActivity(orderIntent);
						finish();
					}
				}).setNegativeButton("Wait", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
						finish();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
