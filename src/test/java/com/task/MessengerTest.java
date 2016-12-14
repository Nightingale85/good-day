package com.task;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

/**
 * @author Sergiy_Solovyov
 */
@RunWith(DataProviderRunner.class)
public class MessengerTest {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { "Good morning, World!", "morning" },
                { "Good day, World!", "day" },
                { "Good evening, World!", "evening" },
                { "Good night, World!", "night" }
        };
    }
    @DataProvider
    public static Object[][] dataRus() {
        return new Object[][] {
                { "Доброе утро, Мир!", "morning" },
                { "Добрый день, Мир!", "day" },
                { "Добрый вечер, Мир!", "evening" },
                { "Доброй ночи, Мир!", "night" }
        };
    }
    @Test
    @UseDataProvider("dataRus")
    public void testMessageRus(final String expected, String dayPart) {
        Locale.setDefault(new Locale("ru"));
        Messages messages = new Messages("messages");
        assertEquals(expected, messages.getMessage(dayPart));
    }
    @Test
    @UseDataProvider("data")
    public void testMessage(final String expected, String dayPart) {
        Locale.setDefault(Locale.ENGLISH);
        Messages messages = new Messages("messages");
        assertEquals(expected, messages.getMessage(dayPart));
    }
}
