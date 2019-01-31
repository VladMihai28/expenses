package com.highflyer.expenses.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

/**
 * Created by Vlad
 */
@RunWith(AndroidJUnit4.class)
public class ExpenseDbHelperTest {

    private final Context context = ApplicationProvider.getApplicationContext();

    @Before
    public void setUp() {
        deleteTheDatabase();
    }

    private void deleteTheDatabase(){
        try {
            Field f = ExpenseDbHelper.class.getDeclaredField("DATABASE_NAME");
            f.setAccessible(true);
            context.deleteDatabase((String)f.get(null));
        }catch (NoSuchFieldException ex){
            fail("No member called DATABASE_NAME in the ExpenseDbHelper");
        }catch (Exception ex){
            fail(ex.getMessage());
        }

    }

    @Test
    public void createDatabase(){
        ExpenseDbHelper dbHelper = new ExpenseDbHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        assertTrue(database.isOpen());

        try (Cursor tableNameCursor = database.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name='" +
                        ExpenseContract.ExpenseEntry.TABLE_NAME + "'",
                null)) {

            assertTrue(tableNameCursor.moveToFirst());
            assertEquals(ExpenseContract.ExpenseEntry.TABLE_NAME, tableNameCursor.getString(0));
        }
    }

    @Test
    public void insertRecord(){
        ExpenseDbHelper dbHelper = new ExpenseDbHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues testValues = new ContentValues();
        testValues.put(ExpenseContract.ExpenseEntry.COLUMN_VALUE, 1f);
        testValues.put(ExpenseContract.ExpenseEntry.COLUMN_CURRENCY, "RON");
        testValues.put(ExpenseContract.ExpenseEntry.COLUMN_CATEGORY, "Other");

        long firstRowId = database.insert(
                ExpenseContract.ExpenseEntry.TABLE_NAME,
                null,
                testValues);

        assertNotEquals(-1, firstRowId);

        try (Cursor cursor = database.query(
                ExpenseContract.ExpenseEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null)){
            assertTrue(cursor.moveToFirst());
        }
        dbHelper.close();
    }

}
