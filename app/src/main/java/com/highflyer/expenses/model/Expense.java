package com.highflyer.expenses.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vlad
 */

public class Expense implements Parcelable {

    private float value;
    private int date;
    private String category;

    public Expense(){}

    public Expense(Parcel parcel){
        this.value = parcel.readFloat();
        this.date = parcel.readInt();
        this.category = parcel.readString();
    }

    public Expense(ExpenseBuilder builder){
        value = builder.value;
        date = builder.date;
        category = builder.category;
    }

    public static class ExpenseBuilder{

        private float value;
        private int date;
        private String category;

        public ExpenseBuilder(){}

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(value);
        parcel.writeInt(date);
        parcel.writeString(category);
    }

    public static final Parcelable.Creator<Expense> CREATOR = new Parcelable.Creator<Expense>() {

        @Override
        public Expense createFromParcel(Parcel parcel) {
            return new Expense(parcel);
        }

        @Override
        public Expense[] newArray(int size) {
            return new Expense[size];
        }
    };
}
