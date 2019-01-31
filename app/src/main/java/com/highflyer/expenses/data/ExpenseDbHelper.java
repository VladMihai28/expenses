package com.highflyer.expenses.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vlad
 */
public class ExpenseDbHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "expenses.db";
    private final static int DATABASE_VERSION = 1;

    public ExpenseDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_EXPENSES_TABLE = "CREATE TABLE " +
                ExpenseContract.ExpenseEntry.TABLE_NAME + " (" +
                ExpenseContract.ExpenseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ExpenseContract.ExpenseEntry.COLUMN_VALUE + " FLOAT NOT NULL, " +
                ExpenseContract.ExpenseEntry.COLUMN_CURRENCY + " TEXT NOT NULL, " +
                ExpenseContract.ExpenseEntry.COLUMN_TRANSACTION_DATE + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                ExpenseContract.ExpenseEntry.COLUMN_CATEGORY + " TEXT NOT NULL" +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_EXPENSES_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        throw new RuntimeException("onUpgrade not implemented yet");
    }
}
