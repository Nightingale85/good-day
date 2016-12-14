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

    private Messages messages = new Messages(Locale.ENGLISH, "messages");
    private Messages messagesRu = new Messages(new Locale("ru", "RU"), "messages");

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
    @UseDataProvider("data")
    public void testMessage(final String expected, String dayPart) {
        assertEquals(expected, messages.getMessage(dayPart));
    }

    @Test
    @UseDataProvider("dataRus")
    public void testMessageRus(final String expected, String dayPart) {
        assertEquals(expected, messagesRu.getMessage(dayPart));
    }
}
