package com.app.filterforget.domain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbData {
	public static final String DB_NAME = "filter_forget.db";
	public static final int DB_VERSION = 1;

	public static final String TABLE_USER = "user";
	public static final String U_ID = BaseColumns._ID;
	public static final String FIRST_NAME = "first_name";
	public static final String LAST_NAME = "last_name";
	public static final String ADDRESS_1 = "address_1";
	public static final String ADDRESS_2 = "addres_2";
	public static final String CITY = "city";
	public static final String STATE = "state";
	public static final String ZIP = "zip";

	public static final String TABLE_CREDIT_CARD = "credit_card";
	public static final String C_ID = BaseColumns._ID;
	public static final String CARD_NUMBER = "card_number";
	public static final String CARD_EXP_DATE = "exp_date";
	public static final String CARD_VERIFICATION_CODE = "cvc";

	public static final String TABLE_FILTER = "filter";
	public static final String F_ID = BaseColumns._ID;
	public static final String FILTER_NAME = "filter_name";
	public static final String FILTER_WIDTH = "filter_width";
	public static final String FILTER_HEIGHT = "filter_height";

	Context context;
	DbHelper dbHelper;
	SQLiteDatabase db;

	public DbData(Context context) {
		this.context = context;
		dbHelper = new DbHelper();
	}

	class DbHelper extends SQLiteOpenHelper {

		public DbHelper() {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}
}
