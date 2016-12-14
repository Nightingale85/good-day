package com.task;

import org.apache.log4j.Logger;
import java.util.NoSuchElementException;

import static com.task.DayPart.*;

/**
 * @author Sergiy_Solovyov
 */
public class Messenger {
    private static final Logger log = Logger.getLogger(Messenger.class);
    private Messages messages;

    public Messenger(Messages messages) {
        this.messages = messages;
    }

    public String getMessage(DayPart dayPart){
        switch (dayPart){
            case MORNING:
                return loadMessage(MORNING);
            case DAY:
                return loadMessage(DAY);
            case EVENING:
                return loadMessage(EVENING);
            case NIGHT:
                return loadMessage(NIGHT);
            default: throw new NoSuchElementException();
        }
    }

    private String loadMessage(DayPart dayPart){
        log.info(dayPart + " getMessage returning");
        return messages.getString(dayPart.toLowerCase());
    }
}
