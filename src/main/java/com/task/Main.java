package com.task;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;
import static com.task.DayPart.*;

/**
 * @author Sergiy_Solovyov
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Messages messages = new Messages(Locale.getDefault(), "messages");
        DayPart dayPart = getDayPart(LocalTime.now());
        Messenger printer = new Messenger(messages);
        System.out.println(printer.message(dayPart));
    }

}
