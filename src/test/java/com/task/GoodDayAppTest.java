package com.task;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalTime;

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
                { "morning", LocalTime.of(6, 0)},
                { "morning", LocalTime.of(8, 0)},
                { "morning", LocalTime.of(8, 59)},
                { "day", LocalTime.of(9, 0)},
                { "day", LocalTime.of(12, 0)},
                { "day", LocalTime.of(18, 59)},
                { "evening", LocalTime.of(19, 0)},
                { "evening", LocalTime.of(22, 0)},
                { "evening", LocalTime.of(22, 59)},
                { "night", LocalTime.of(23, 00)},
                { "night", LocalTime.of(23, 59)},
                { "night", LocalTime.of(0, 0)},
                { "night", LocalTime.of(3, 0)},
                { "night", LocalTime.of(5, 59)}
        };
    }
    @Test
    @UseDataProvider("data")
    public void testGetDayPart(String dayPart, final LocalTime time) {
        assertEquals(dayPart, getDayPart(time));
    }
}
