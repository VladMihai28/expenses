package com.highflyer.expenses.data;

import android.provider.BaseColumns;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

    @Test(expected = IllegalStateException.class)
    public void checkExpenseEntryClassValidity() throws Throwable {
        Class[] innerClasses = ExpenseContract.class.getDeclaredClasses();
        Class entryClass = innerClasses[0];
        assertTrue(BaseColumns.class.isAssignableFrom(entryClass));
        assertTrue(Modifier.isFinal(entryClass.getModifiers()));
        assertTrue(Modifier.isStatic(entryClass.getModifiers()));
        Constructor<?> constructor = null;
        try {
            constructor = ExpenseContract.ExpenseEntry.class.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fail();
        }
        if (constructor.isAccessible()
                || !Modifier.isPrivate(constructor.getModifiers())) {
            fail("Constructor is not private");
        }
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            assertEquals("DB Contract Class", e.getCause().getMessage());
            throw e.getCause();
        } catch (IllegalAccessException e) {
            fail();
        } catch (InstantiationException e) {
            fail();
        }
        constructor.setAccessible(false);
        for (final Method method : ExpenseContract.ExpenseEntry.class.getMethods()) {
            if (!Modifier.isStatic(method.getModifiers())
                    && method.getDeclaringClass().equals(ExpenseContract.class)) {
                fail("Unexpected non-static method:" + method);
            }
        }

    }

}

