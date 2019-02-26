package com.highflyer.expenses.data;

import android.provider.BaseColumns;

/**
 * Created by Vlad
 */
public class ExpenseContract {

    private ExpenseContract(){}

    public static final class ExpenseEntry implements BaseColumns {

        private ExpenseEntry() {
            throw new IllegalStateException("DB Contract Class");
        }

        public static final String TABLE_NAME = "expenses";
        public static final String COLUMN_VALUE = "value";
        public static final String COLUMN_CURRENCY = "currency";
        public static final String COLUMN_TRANSACTION_DATE = "date";
        public static final String COLUMN_CATEGORY = "category";

    }

}
