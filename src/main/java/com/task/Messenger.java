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
                log.info("Morning message returning");
                return resources.getString(MORNING.name().toLowerCase());
            case DAY:
                log.info("Day message returning");
                return resources.getString(DAY.name().toLowerCase());
            case EVENING:
                log.info("Evening message returning");
                return resources.getString(EVENING.name().toLowerCase());
            case NIGHT:
                log.info("Night message returning");
                return resources.getString(NIGHT.name().toLowerCase());
            default: throw new NoSuchElementException();
        }
    }
}
