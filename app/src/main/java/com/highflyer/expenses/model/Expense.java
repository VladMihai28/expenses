package com.highflyer.expenses.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vlad
 */

public class Expense {

    private float value;
    private int date;
    private String category;
    private String currency;

    
    public Expense(){}

    public Expense(ExpenseBuilder builder){
        value = builder.value;
        date = builder.date;
        category = builder.category;
        currency = builder.currency;
    }

    public static class ExpenseBuilder{

        private float value;
        private int date;
        private String category;
        private String currency;

        public ExpenseBuilder value(float newValue){
            value = newValue;
            return this;
        }
        public ExpenseBuilder date(int newDate){
            date = newDate;
            return this;
        }
        public ExpenseBuilder category(String newCategory){
            category = newCategory;
            return this;
        }
        public ExpenseBuilder currency(String newCurrency){
            currency = newCurrency;
            return this;
        }

        public Expense build(){
            return new Expense(this);
        }
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getValue() {
        return value;
    }

    public int getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
