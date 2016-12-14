package com.task;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Locale;
import static com.task.DayPart.*;
import static com.task.DayPart.NIGHT;
import static org.junit.Assert.assertEquals;

/**
 * @author Sergiy_Solovyov
 */
@RunWith(DataProviderRunner.class)
public class MessengerTest {

    private Messenger messengerEn = new Messenger(new Messages(Locale.ENGLISH, "messages"));
    private Messenger messengerRus = new Messenger(new Messages(new Locale("ru", "RU"), "messages"));

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { "Good morning, World!", MORNING },
                { "Good day, World!", DAY },
                { "Good evening, World!", EVENING },
                { "Good night, World!", NIGHT }
        };
    }
    @DataProvider
    public static Object[][] dataRus() {
        return new Object[][] {
                { "Доброе утро, Мир!", MORNING },
                { "Добрый день, Мир!", DAY },
                { "Добрый вечер, Мир!", EVENING },
                { "Доброй ночи, Мир!", NIGHT }
        };
    }
    @Test
    @UseDataProvider("data")
    public void testMessage(final String expected, DayPart dayPart) {
        assertEquals(expected, messengerEn.getMessage(dayPart));
    }

    @Test
    @UseDataProvider("dataRus")
    public void testMessageRus(final String expected, DayPart dayPart) {
        assertEquals(expected, messengerRus.getMessage(dayPart));
    }
}
