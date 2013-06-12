package com.app.filterforget.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
	public static final String FILTER_LENGTH = "filter_length";
	public static final String FILTER_CHECKED = "filter_checked";
	public static final String FILTER_PRICE = "filter_price";
	public static final String FILTER_QUANTITY = "filter_quantity";
	public static final String FILTER_LAST_REPLACED = "filter_last_replaced";

	public static final String CREATE_TABLE_USER = String.format(
			"Create table %s (%s integer primary key, %s text, %s text, %s text, %s text, %s text, %s text, %s text)",
			TABLE_USER, U_ID, FIRST_NAME, LAST_NAME, ADDRESS_1, ADDRESS_2, CITY, STATE, ZIP);
	public static final String CREATE_SINGLE_USER = "Insert into user values (1, \"\", \"\", \"\", \"\", \"\", \"\", \"\");";
	public static final String CREATE_TABLE_CARDS = String.format(
			"Create table %s (%s integer primary key, %s text, %s text, %s text)", TABLE_CREDIT_CARD, C_ID,
			CARD_NUMBER, CARD_EXP_DATE, CARD_VERIFICATION_CODE);
	public static final String CREATE_TABLE_FILTERS = String
			.format("Create table %s (%s integer primary key, %s text, %s text, %s text, %s text, %s text, %s text, %s text, %s text)",
					TABLE_FILTER, F_ID, FILTER_NAME, FILTER_WIDTH, FILTER_HEIGHT, FILTER_LENGTH, FILTER_CHECKED,
					FILTER_PRICE, FILTER_QUANTITY, FILTER_LAST_REPLACED);

	Context context;
	DbHelper dbHelper;
	SQLiteDatabase db;

	public DbData(Context context) {
		this.context = context;
		dbHelper = new DbHelper();
//		db = dbHelper.getWritableDatabase();
//		dbHelper.onUpgrade(db, 1, 2);
	}

	public void insertUser(User user) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(U_ID, 1);
		values.put(FIRST_NAME, user.getFirstName());
		values.put(LAST_NAME, user.getLastName());
		values.put(ADDRESS_1, user.getAddress1());
		values.put(ADDRESS_2, user.getAddress2());
		values.put(CITY, user.getCity());
		values.put(STATE, user.getState());
		values.put(ZIP, user.getZipcode());

		db.insert(TABLE_USER, null, values);
		db.close();
	}

	public void updateUser(User user) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(U_ID, 1);
		values.put(FIRST_NAME, user.getFirstName());
		values.put(LAST_NAME, user.getLastName());
		values.put(ADDRESS_1, user.getAddress1());
		values.put(ADDRESS_2, user.getAddress2());
		values.put(CITY, user.getCity());
		values.put(STATE, user.getState());
		values.put(ZIP, user.getZipcode());
		
		db.update(TABLE_USER, values, BaseColumns._ID + "= 1", null);
		db.close();
	}

	public Cursor getUser() {
		db = dbHelper.getWritableDatabase();
		Cursor cursor = db.query(TABLE_USER, null, null, null, null, null, U_ID + "= 1");
		return cursor;
	}

	public void insertFilter(Filter filter) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(FILTER_NAME, filter.getName());
		values.put(FILTER_WIDTH, filter.getWidth());
		values.put(FILTER_HEIGHT, filter.getHeight());
		values.put(FILTER_LENGTH, filter.getLength());
		values.put(FILTER_CHECKED, filter.getChecked());
		values.put(FILTER_PRICE, filter.getPrice());
		values.put(FILTER_QUANTITY, filter.getQuantity());
		values.put(FILTER_LAST_REPLACED, filter.getLastReplaced());

		db.insert(TABLE_FILTER, null, values);
		db.close();
	}

	public void deleteFilter(long id) {
		db = dbHelper.getWritableDatabase();
		db.delete(TABLE_FILTER, F_ID + "=" + id, null);
		db.close();
	}

	public Cursor getFilters() {
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(TABLE_FILTER, null, null, null, null, null, null);
		return cursor;
	}

	public void insertCreditCard(CreditCard creditCard) {
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(CARD_NUMBER, creditCard.getCardNumber());
		values.put(CARD_EXP_DATE, creditCard.getExpDate());
		values.put(CARD_VERIFICATION_CODE, creditCard.getCvc());

		db.insert(TABLE_CREDIT_CARD, null, values);
		db.close();
	}

	public void deleteCreditCard(CreditCard creditCard) {
		db = dbHelper.getReadableDatabase();
		db.delete(TABLE_CREDIT_CARD, C_ID + "=" + creditCard.getId(), null);
		db.close();
	}

	public Cursor getCreditCards() {
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(TABLE_CREDIT_CARD, null, null, null, null, null, null);
		return cursor;
	}

	class DbHelper extends SQLiteOpenHelper {

		public DbHelper() {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_TABLE_USER);
			db.execSQL(CREATE_SINGLE_USER);
			db.execSQL(CREATE_TABLE_CARDS);
			db.execSQL(CREATE_TABLE_FILTERS);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("drop TABLE " + TABLE_USER + ";");
			db.execSQL("drop TABLE " + TABLE_CREDIT_CARD + ";");
			db.execSQL("drop TABLE " + TABLE_FILTER + ";");
			onCreate(db);
		}

	}
}
