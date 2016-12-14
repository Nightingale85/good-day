package com.task;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.task.GoodDayApp.getDayPart;
import static org.junit.Assert.assertEquals;

/**
 * @author Sergiy_Solovyov
 */
@RunWith(DataProviderRunner.class)
public class GoodDayAppTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { "morning", 6},
                { "morning", 7},
                { "morning", 8},
                { "day", 9},
                { "day", 12},
                { "day", 18},
                { "evening", 19},
                { "evening", 21},
                { "evening", 22},
                { "night", 23},
                { "night", 0},
                { "night", 2},
                { "night", 3},
                { "night", 5}
        };
    }
    @Test
    @UseDataProvider("data")
    public void testGetDayPart(String dayPart, final int hour) {
        assertEquals(dayPart, getDayPart(hour));
    }
}
