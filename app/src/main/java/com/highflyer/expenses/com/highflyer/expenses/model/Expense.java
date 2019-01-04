package com.highflyer.expenses.com.highflyer.expenses.model;

/**
 * Created by Vlad
 */

public class Expense {

    private float value;
    private int date;
    private String category;

    public Expense(float value, int date, String category){
        this.value = value;
        this.date = date;
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
}
