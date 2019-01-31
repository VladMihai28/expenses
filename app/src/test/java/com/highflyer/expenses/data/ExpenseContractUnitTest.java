package com.highflyer.expenses.data;

import android.provider.BaseColumns;

import org.junit.Test;

import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vlad
 */
public class ExpenseContractUnitTest {

    @Test
    public void innerClassExists(){
        Class[] innerClasses = ExpenseContract.class.getDeclaredClasses();
        assertEquals(1, innerClasses.length);
    }

    @Test
    public void staticEntryClass() {
        assertNotNull(ExpenseContract.ExpenseEntry.class);
    }

    @Test
    public void inner_class_type_correct(){
        Class[] innerClasses = ExpenseContract.class.getDeclaredClasses();
        Class entryClass = innerClasses[0];
        assertTrue(BaseColumns.class.isAssignableFrom(entryClass));
        assertTrue(Modifier.isFinal(entryClass.getModifiers()));
        assertTrue(Modifier.isStatic(entryClass.getModifiers()));
    }

}

