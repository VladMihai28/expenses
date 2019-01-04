package com.highflyer.expenses.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpenseUnitTest {

    @Test
    public void defaultConstructor() {
        Expense expense = new Expense();
        assertNotNull(expense);
    }

    @Test
    public void builderEmpty() {
        Expense expense = new Expense.ExpenseBuilder().build();
        assertNotNull(expense);
    }

    @Test
    public void builderValue() {
        Expense expense = new Expense.ExpenseBuilder()
                .value(15.5f)
                .build();
        assertEquals(15.5f, expense.getValue(), 0);
    }

    @Test
    public void builderDate() {
        Expense expense = new Expense.ExpenseBuilder()
                .date(27)
                .build();
        assertEquals(27, expense.getDate());
    }

    @Test
    public void builderCategory() {
        Expense expense = new Expense.ExpenseBuilder()
                .category("food")
                .build();
        assertEquals("food", expense.getCategory());
    }

    @Test
    public void setValue() {
        Expense expense = new Expense.ExpenseBuilder()
                .value(15.5f)
                .build();
        expense.setValue(23.4f);
        assertEquals(23.4f, expense.getValue(), 0);
    }

    @Test
    public void setDate() {
        Expense expense = new Expense.ExpenseBuilder()
                .date(27)
                .build();
        expense.setDate(53);
        assertEquals(53, expense.getDate());
    }

    @Test
    public void setCategory() {
        Expense expense = new Expense.ExpenseBuilder()
                .category("food")
                .build();
        expense.setCategory("house");
        assertEquals("house", expense.getCategory());
    }

}