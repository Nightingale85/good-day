package com.task;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;

/**
 * @author Sergiy_Solovyov
 */
public class GoodDayApp {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Messages messages = new Messages("messages");
        System.out.println(messages.getMessage(getDayPart(LocalTime.now().getHour())));
    }

    public static String getDayPart(int hour){
       if (6 <= hour && hour < 9){
           return "morning";
       } else if (9 <= hour && hour < 19){
           return "day";
       } else if (19 <= hour && hour < 23){
           return "evening";
       } else return "night";
   }
}
