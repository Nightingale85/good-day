package com.task;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import static com.task.DayPart.*;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Sergiy_Solovyov
 */
@RunWith(DataProviderRunner.class)
public class DayPartTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { MORNING, LocalTime.of(6, 00, 00)},
                { MORNING, LocalTime.of(7, 30)},
                { MORNING, LocalTime.of(8, 59, 59)},
                { DAY, LocalTime.of(9, 00, 00) },
                { DAY, LocalTime.of(12, 00) },
                { DAY, LocalTime.of(18, 59, 59) },
                { EVENING, LocalTime.of(19, 00, 00) },
                { EVENING, LocalTime.of(20, 15) },
                { EVENING, LocalTime.of(22, 59, 59) },
                { NIGHT, LocalTime.of(23, 00, 00) },
                { NIGHT, LocalTime.of(3, 05) },
                { NIGHT, LocalTime.of(5, 59, 59) }
        };
    }
    @Test
    @UseDataProvider("data")
    public void testGetDayPart(DayPart dayPart, final LocalTime time) {
        assertEquals(dayPart, getDayPart(time));
    }
}
