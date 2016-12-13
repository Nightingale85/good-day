package com.task;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * @author Sergiy_Solovyov
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        Messages messages = new Messages(Locale.getDefault(), "messages");
        TimeChecker timeChecker = new TimeChecker();
        DayPart dayPart = timeChecker.getDayPart(LocalTime.now());
        Messenger printer = new Messenger(messages);
        System.out.println(printer.message(dayPart));;
    }

}
