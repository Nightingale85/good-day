package com.task;

import org.apache.log4j.Logger;

import java.util.NoSuchElementException;

import static com.task.DayPart.*;

/**
 * @author Sergiy_Solovyov
 */
public class Messenger {
    private static final Logger log = Logger.getLogger(Messenger.class);
    private Messages resources;

    public Messenger(Messages resources) {
        this.resources = resources;
    }

    public String message(DayPart dayPart){
        switch (dayPart){
            case MORNING:
                return getMessage(MORNING);
            case DAY:
                return getMessage(DAY);
            case EVENING:
                return getMessage(EVENING);
            case NIGHT:
                return getMessage(NIGHT);
            default: throw new NoSuchElementException();
        }
    }

    private String getMessage(DayPart dayPart){
        log.info(dayPart + " message returning");
        return resources.getString(dayPart.toLowerCase());
    }
}
